package com.davahamka.kinder.presentation

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.AsyncTask
import android.provider.Settings
import android.util.Log
import android.util.Size
import androidx.camera.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.override
import androidx.core.content.ContextCompat
import com.davahamka.kinder.ml.ObjectDetectorImageAnalyzer
import com.davahamka.kinder.presentation.ui.component.TopBarDescription
import com.davahamka.kinder.presentation.ui.theme.Green3
import com.davahamka.kinder.presentation.ui.theme.PrimaryColor
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.objects.ObjectDetection
import com.google.mlkit.vision.objects.defaults.ObjectDetectorOptions
import com.google.mlkit.vision.objects.defaults.PredefinedCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

@SuppressLint("UnsafeOptInUsageError")
@Composable
fun CameraCapture(
    modifier: Modifier = Modifier,
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_BACK_CAMERA,
    onImageFile: (File) -> Unit = { }
) {
    val context = LocalContext.current

    val cameraExecutor = remember { Executors.newSingleThreadExecutor() }

    Permission(
        permission = Manifest.permission.CAMERA,
        rationale = "You said you wanted a picture, so I'm going to have to ask for permission.",
        permissionNotAvailableContent = {
            Column(modifier) {
                Text("O noes! No Camera!")
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = {
                    context.startActivity(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                        data = Uri.fromParts("package", context.packageName, null)
                    })
                }) {
                    Text("Open Settings")
                }
            }
        }
    ) {
       
        Scaffold(
            topBar = { TopBarDescription(title = "Check your food") }
        ) {
            Box(modifier = modifier) {
                val lifecycleOwner = LocalLifecycleOwner.current
                val coroutineScope = rememberCoroutineScope()
                var previewUseCase by remember { mutableStateOf<UseCase>(Preview.Builder().build()) }
                val imageCaptureUseCase by remember {
                    mutableStateOf(
                        ImageCapture.Builder()
                            .setCaptureMode(ImageCapture.CAPTURE_MODE_MAXIMIZE_QUALITY)
                            .build()
                    )
                }
                Box {
                    CameraPreview(
                        modifier = Modifier.fillMaxSize(),
                        onUseCase = {
                            previewUseCase = it
                        }
                    )

                    Column(modifier = Modifier.align(
                        Alignment.Center
                    )) {
                        Text(text = "Good Condition", fontWeight = FontWeight.Bold, color = PrimaryColor, textAlign = TextAlign.Center, modifier =Modifier.padding(bottom = 2.dp))
                        Box(
                            modifier = Modifier
                                .border(4.dp, color = PrimaryColor)
                                .width(240.dp)
                                .height(240.dp)

                        ) {

                        }
                    }

                    Button(
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = PrimaryColor,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(24.dp),
                        modifier = Modifier
                            .width(300.dp)
                            .padding(32.dp)
                            .align(Alignment.BottomCenter)
                        ,
                        contentPadding = PaddingValues(vertical = 12.dp),
                        onClick = {
                            coroutineScope.launch {
                                imageCaptureUseCase.takePicture(context.executor).let {
                                    onImageFile(it)
                                }
                            }
                        }
                    ) {
                        Text("Continue")
                    }
                }
                LaunchedEffect(previewUseCase) {

                    val options = ObjectDetectorOptions.Builder()
                        .setDetectorMode(ObjectDetectorOptions.STREAM_MODE)
                        .enableClassification()
                        .build()

                    val objectDetector = ObjectDetection.getClient(options)



                    val imageAnalysis = ImageAnalysis.Builder()
                        .setTargetResolution(Size(1280, 70))
                        .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                        .build()



                    imageAnalysis.setAnalyzer(cameraExecutor, ImageAnalysis.Analyzer {
                        val mediaImage = it.image
                        if (mediaImage != null) {

                            val image = InputImage.fromMediaImage(mediaImage, it.imageInfo.rotationDegrees)

                            objectDetector.process(image)
                                .addOnSuccessListener { detectedObjects ->
                                    Log.d("DO", detectedObjects.toString())
                                    for (detectedObject in detectedObjects) {
                                        val boundingBox = detectedObject.boundingBox
                                        val trackingId = detectedObject.trackingId

                                        for (label in detectedObject.labels) {
                                            val text = label.text
                                            if (PredefinedCategory.FOOD == text) {

                                            }
                                            val index = label.index
                                            if (PredefinedCategory.FOOD_INDEX == index) {

                                            }
                                            val confidence = label.confidence
                                            Log.d("ML_RESULT", text)
                                            Log.d("ML_CONFIDENCE", confidence.toString())
                                        }
                                    }
                                }.addOnFailureListener { e ->
                                    Log.d("MLERR", e.message.toString())
                                }
                        }
                    })

                    val cameraProvider = context.getCameraProvider()
                    try {
                        // Must unbind the use-cases before rebinding them.
                        cameraProvider.unbindAll()
                        cameraProvider.bindToLifecycle(
                            lifecycleOwner, cameraSelector, imageAnalysis, previewUseCase, imageCaptureUseCase,
                        )
                    } catch (ex: Exception) {
                        Log.e("CameraCapture", "Failed to bind camera use cases", ex)
                    }
                }
            }
        }
    }
}

suspend fun ImageCapture.takePicture(executor: Executor): File {
    val photoFile = withContext(Dispatchers.IO) {
        kotlin.runCatching {
            File.createTempFile("image", "jpg")
        }.getOrElse { ex ->
            Log.e("TakePicture", "Failed to create temporary file", ex)
            File("/dev/null")
        }
    }

    return suspendCoroutine { continuation ->
        val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()
        takePicture(outputOptions, executor, object : ImageCapture.OnImageSavedCallback {
            override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                continuation.resume(photoFile)
            }
            override fun onError(ex: ImageCaptureException) {
                Log.e("TakePicture", "Image capture failed", ex)
                continuation.resumeWithException(ex)
            }
        })
    }
}

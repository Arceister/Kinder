package com.davahamka.kinder.presentation.donate

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Eject
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.davahamka.kinder.R
import com.davahamka.kinder.dummy.DonateDummy
import com.davahamka.kinder.presentation.home.components.ModalBottomShare
import com.davahamka.kinder.presentation.home.components.ModalDetailReceiver
import com.davahamka.kinder.static.NearestDataStatic
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DonateMapScreen(navController: NavHostController) {
        val singapore =  LatLng(-7.9354264,112.6239592)

        val modalBottomSheetState = rememberModalBottomSheetState(
            ModalBottomSheetValue.Hidden
        )

        val coroutineScope = rememberCoroutineScope()

        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(singapore, 16f)
        }
    
        ModalBottomSheetLayout(
            sheetState = modalBottomSheetState,
            sheetContent = {
                ModalDetailReceiver(navController)
        }) {
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState,
//                properties = MapProperties(isMyLocationEnabled = true),
                uiSettings = MapUiSettings(myLocationButtonEnabled = true)
            ) {

                NearestDataStatic.dataCard.forEach {
                    val iconMarker = BitmapDescriptorFactory.fromResource(R.drawable.icon_person_marker)
                    Marker(
                        position = it.position,
                        title = it.name,
                        icon = iconMarker,
                        snippet = "Tes",
                        onClick = {
                            coroutineScope.launch { modalBottomSheetState.show() }
                            true
                        }
                    )
                }

            }
        }
    

}
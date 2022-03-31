package com.davahamka.kinder.presentation.donate

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.davahamka.kinder.R
import com.davahamka.kinder.presentation.home.components.ModalDetailItem
import com.davahamka.kinder.presentation.home.components.ModalDetailReceiver
import com.davahamka.kinder.static.NearestDataStatic
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DonateDetailMapScreen(navController: NavController) {
    val singapore =  LatLng(-7.9354264,112.6239592)

    val modalBottomSheetState = rememberModalBottomSheetState(
        ModalBottomSheetValue.HalfExpanded
    )

    val coroutineScope = rememberCoroutineScope()

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 16f)
    }

    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetContent = {
            ModalDetailItem(navController)
        }) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
//                properties = MapProperties(isMyLocationEnabled = true),
            uiSettings = MapUiSettings(myLocationButtonEnabled = true)
        ) {

            val iconMarker = BitmapDescriptorFactory.fromResource(R.drawable.icon_person_marker)
            Marker(position = singapore, icon = iconMarker, onClick = {
                coroutineScope.launch { modalBottomSheetState.show() }
                Log.d("TEST","SINGA")
                true
            })

        }
    }
}
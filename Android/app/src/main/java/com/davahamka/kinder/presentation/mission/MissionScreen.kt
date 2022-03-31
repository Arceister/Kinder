package com.davahamka.kinder.presentation.mission

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.davahamka.kinder.presentation.mission.components.MissionCard
import com.davahamka.kinder.presentation.mission.components.SwipeCard
import com.davahamka.kinder.presentation.ui.component.BottomNavigationBar
import com.davahamka.kinder.presentation.ui.component.TopBarMission
import com.davahamka.kinder.static.MissionDetailDataStatic

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MissionScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopBarMission(title = "Mission")
        },
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) {
        Box(modifier = Modifier.fillMaxSize().padding(top = 12.dp, start = 24.dp, end = 24.dp, bottom = 64.dp),contentAlignment = Alignment.Center){
            MissionDetailDataStatic.dataCard.map {
                SwipeCard(onSwiped = {}) {
                    MissionCard(it)
                }
            }
        }

    }
}
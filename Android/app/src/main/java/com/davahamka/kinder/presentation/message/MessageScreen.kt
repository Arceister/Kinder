package com.davahamka.kinder.presentation.message

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.davahamka.kinder.presentation.message.components.ListMessage
import com.davahamka.kinder.presentation.ui.component.BottomNavigationBar
import com.davahamka.kinder.presentation.ui.component.TopBarMission

@Composable
fun MessageScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar( navController = navController) },
        topBar = { TopBarMission("Message") }
    ) {
        ListMessage(navController)
    }
}
package com.davahamka.kinder.presentation.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.painter.Painter
import com.davahamka.kinder.R

sealed class NavigationItem(
    var route: String,
    var icon: Int,
    var iconSelected: Int,
    var title: String) {
    object Home: NavigationItem("home_screen", R.drawable.icon_outline_home,R.drawable.icon_filled_home, title= "Home")
    object Mission: NavigationItem("mission_screen", R.drawable.icon_target , R.drawable.icon_target, title = "Mission")
    object Message: NavigationItem("message_screen", R.drawable.icon_outline_chat, R.drawable.icon_filled_chat, title = "Message")
    object Account: NavigationItem("account_screen", R.drawable.icon_outline_person,  R.drawable.icon_filled_person, title = "Account")
}

package com.davahamka.kinder.static

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.davahamka.kinder.R

data class ListMenuAccount(
    val image: Int,
    val text: String
)

object ListMenuAccountDataStatic {
    val dataCard = listOf(
        ListMenuAccount(R.drawable.ic_acc_profile, text = "Profile"),
        ListMenuAccount(R.drawable.ic_acc_history, text = "History Activity"),
        ListMenuAccount(R.drawable.ic_acc_level, text = "My Level"),
        ListMenuAccount(R.drawable.ic_acc_myacc, text = "My Account"),
        ListMenuAccount(R.drawable.ic_acc_logout, text = "Logout")
    )
}
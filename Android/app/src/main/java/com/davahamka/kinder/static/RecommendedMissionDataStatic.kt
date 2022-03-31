package com.davahamka.kinder.static

import androidx.compose.ui.graphics.Color

data class RecommendedMission(
    val title: String,
    val color: Color,
    val people: Int,
    val textColor: Color
)

object RecommendedMissionDataStatic {
    val dataCard = listOf(
        RecommendedMission("Take a donation from Mr. Bayu, the fruit seller of Pasar Senen", Color(0xffFDE7F4), 4000, textColor = Color(0xffE66480)),
        RecommendedMission("Send a good item condition to another people", Color(0xfffff7d6), 200, textColor = Color(0xffFC9E4F)),
        RecommendedMission("Take a donation from Mr. Handy, the fruit seller of Pasar Senen", Color(0xffd7ecff), 3123, textColor = Color(0xff6A9BC8))
    )
}
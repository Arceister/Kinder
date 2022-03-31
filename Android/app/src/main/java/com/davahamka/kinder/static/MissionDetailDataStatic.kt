package com.davahamka.kinder.static


import androidx.compose.ui.graphics.Color
import com.davahamka.kinder.R

data class MissionDetail(
    val type: String,
    val imgMission: Int,
    val xp: Int,
    val title: String,
    val description: String,
    val peopleFollow: Int,
    val bgColor: Color,
    val titleColor: Color,
    val btnColor: Color
)

object MissionDetailDataStatic {
    val dataCard = listOf(
        MissionDetail("Donate", R.drawable.img_mission_takeaway, xp = 100, title = "Take food donation from Bu Yuli", description = "Donate free boxed rice meals to people who are being affected by the Covid-19 pandemic\\n\" +\n" +
                "in the Malang City area", peopleFollow = 1200, bgColor = Color(0xFFFDE7F4), titleColor = Color(0xFFE66480), btnColor =Color(0xFFE7335A)),
        MissionDetail("Donate", R.drawable.img_mission_fruitveg, xp = 80, title = "Take food donation from Bu Yuli", description = "Donate free boxed rice meals to people who are being affected by the Covid-19 pandemic\\n\" +\n" +
                "in the Malang City area", peopleFollow = 500, bgColor = Color(0xFFD7ECFF), titleColor = Color(0xFF6A9BC8), btnColor =Color(0xFF3887CF)),
        MissionDetail("Cheap Sale", R.drawable.img_mission_fruit, xp = 200, title = "Follow the Dragon Fruit Sale on Mr. Wahyu's house", description = "\n" +
                "The dragon fruit that we are selling is a dragon fruit that does not enter the export and market quality. Instead of throwing it away, we choose to sell it at a lower price", peopleFollow = 100, bgColor = Color(0xFFFFF7D6), titleColor = Color(0xFFFC9E4F), btnColor =Color(0xFFFE841D))
        )
}
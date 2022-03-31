package com.davahamka.kinder.static

import androidx.compose.ui.graphics.painter.Painter
import com.davahamka.kinder.R

data class DataCard(
    val title: String,
    val description: String,
    val image: Int
)

object InformationDataStatic {
    val dataCard = listOf<DataCard>(
        DataCard(
            "Find good things",
            description = "\n" +
                    "Ease of finding donation targets " +
                    "by performing AI scans on food and " +
                    "choose the shipping method",
            image = R.drawable.img_information_one
            ),
        DataCard(
            "Variety of free food",
            description = "Easy access in finding location " +
                    "pembagian makanan gratis dari berbagai aksi " +
                    "free food distribution from various actions",
            image = R.drawable.img_information_2
            ),
        DataCard(
            "Find cheap commodities",
            description = "Kemudahan dalam menemukan lokasi " +
                    "Ease of finding the location " +
                    "various prepared and raw foods",
            image = R.drawable.img_information_three
        ),
    )
}
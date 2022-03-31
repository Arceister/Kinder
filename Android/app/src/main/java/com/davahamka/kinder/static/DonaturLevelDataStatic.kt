package com.davahamka.kinder.static

import com.davahamka.kinder.R

data class DonaturLevel(
    val image: Int,
    val name: String,
    val point: Int
)

object DonaturLevelDataStatic {
    val dataCard = listOf(
        DonaturLevel(R.drawable.img_level_godhand, name = "God Hand", point = 60000),
        DonaturLevel(R.drawable.img_level_theking,  name = "The King", point = 35000),
        DonaturLevel(R.drawable.img_level_theking, name = "Treasurers", point = 20000),
        DonaturLevel(R.drawable.img_level_savior, name = "The Savior", point = 10000),
        DonaturLevel(R.drawable.img_level_generous, name = "Generous Donor", point = 2000),
        DonaturLevel(R.drawable.img_level_pioneer, name = "Donation Pioneer", point = 2000),
        DonaturLevel(R.drawable.img_level_mover, name = "Donation Activist", point = 2000),
    )
}
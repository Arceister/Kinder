package com.davahamka.kinder.static

import androidx.compose.ui.graphics.Color

data class NutrionSummary(
    val percent: Int,
    val name: String,
    val gram: Int,
    val colorBackground: Color,
    val colorText: Color
)

object NutritionSummaryDataStatic {
    val dataNutrionSummary = listOf(
        NutrionSummary(percent = 50, name = "Water", colorBackground = Color(0xff0EC7E0).copy(0.2f),colorText = Color(0xff3165D8), gram = 48),
        NutrionSummary(percent = 50, name = "Carbo", colorBackground = Color(0xffF1963A).copy(0.2f),colorText = Color(0xffF1963A), gram = 43),
        NutrionSummary(percent = 50, name = "Protein", colorBackground = Color(0xffC7CEDC),colorText = Color(0xff5073B8), gram = 94),
        NutrionSummary(percent = 50, name = "Fat", colorBackground = Color(0xffB9DBD6),colorText = Color(0xff0AB39C), gram = 38),
        NutrionSummary(percent = 50, name = "Vitamin", colorBackground = Color(0xffE7CBC5),colorText = Color(0xffF16548), gram = 28),
    )
}

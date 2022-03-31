package com.davahamka.kinder.presentation.leaderboard.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.davahamka.kinder.static.DonaturDataStatic
import com.davahamka.kinder.static.DonaturLevelDataStatic

@Composable
fun LevelList() {
    Column {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Level", color = Color(0xFF888484), fontWeight = FontWeight.Bold)
            Text(text = "Point", color = Color(0xFF888484), fontWeight = FontWeight.Bold)
        }
        DonaturLevelDataStatic.dataCard.forEach {
            LevelItem(it)
        }
    }
}
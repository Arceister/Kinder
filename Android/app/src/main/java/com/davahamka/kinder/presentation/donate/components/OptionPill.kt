package com.davahamka.kinder.presentation.donate.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.davahamka.kinder.presentation.ui.theme.Green3

@Composable
fun OptionPill(text: String, notRecommended: Boolean) {
    Column(
        modifier = Modifier.background(color = Color.White, shape = RoundedCornerShape(12.dp)).border(width = 2.dp, color = if(notRecommended) Color(0xffBD0000) else Green3, shape = RoundedCornerShape(12.dp))
    ) {
        Text(text = text, color = if(notRecommended) Color(0xffBD0000) else Green3, modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp), fontWeight = FontWeight.Bold)
    }
}
package com.davahamka.kinder.presentation.donate.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.davahamka.kinder.presentation.ui.theme.Black1
import com.davahamka.kinder.presentation.ui.theme.Grey2
import com.davahamka.kinder.presentation.ui.theme.Orange1

@Composable
fun QuantityPill(value: String, active: Boolean, onClick: ()->Unit) {
    Column(
        modifier = Modifier
            .background(color = if (active) Orange1 else Grey2, shape = RoundedCornerShape(24.dp))
            .width(54.dp)
            .height(37.dp).clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = value, color = if (active) Color.White else Black1)
    }
    Spacer(modifier = Modifier.width(20.dp))
}
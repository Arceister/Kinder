package com.davahamka.kinder.presentation.message.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ReceiverBox(text: String) {
    Column() {
        Row(
            modifier = Modifier
                .padding(top = 18.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Gambar", modifier = Modifier.fillMaxWidth(0.15f))
            Spacer(modifier = Modifier.width(6.dp))
            Column(
                modifier = Modifier
                    .background(
                        color = Color(0xFFE3E3E3),
                        shape = RoundedCornerShape(
                            topStart = 12.dp,
                            topEnd = 12.dp,
                            bottomEnd = 12.dp
                        )
                    )
                    .fillMaxWidth(0.9f)
                    .padding(horizontal = 14.dp, vertical = 8.dp)
            ) {
                Text(text = text, color = Color(0xFF455B79))
            }
            Spacer(modifier = Modifier.fillMaxWidth(0.9f))
        }
    }
}
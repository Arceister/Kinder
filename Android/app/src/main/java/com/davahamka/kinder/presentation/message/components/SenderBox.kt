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
fun SenderBox(text: String) {
    Column() {
        Row(
            modifier = Modifier
                .padding(top = 18.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .background(
                        color = Color(0xFFFBDB9B),
                        shape = RoundedCornerShape(
                            topStart = 12.dp,
                            bottomStart = 12.dp,
                            topEnd = 12.dp
                        )
                    )
                    .padding(horizontal = 14.dp, vertical = 8.dp)
            ) {
                Text(text = text, color = Color(0xFF535353))
            }
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = "Gambar")
        }
    }
}
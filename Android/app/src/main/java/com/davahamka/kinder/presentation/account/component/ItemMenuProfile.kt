package com.davahamka.kinder.presentation.account.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemMenuProfile(text: String, image: Int) {
    Column(modifier = Modifier
        .fillMaxWidth()
        ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(62.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.background(color = Color(0xFF4DB32B).copy(0.1f), shape = CircleShape).padding(12.dp)
            ) {
                Image(painter = painterResource(id = image), contentDescription = null, modifier = Modifier.size(36.dp))
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = text, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
        Divider(thickness = 1.dp)
    }
}
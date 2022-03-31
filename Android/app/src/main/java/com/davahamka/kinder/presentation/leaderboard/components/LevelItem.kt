package com.davahamka.kinder.presentation.leaderboard.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.davahamka.kinder.presentation.ui.theme.Black1
import com.davahamka.kinder.static.Donatur
import com.davahamka.kinder.static.DonaturLevel
import java.security.AllPermission

@Composable
fun LevelItem(data: DonaturLevel) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(76.dp)
            .padding(horizontal = 18.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color(0xFF4DB32B).copy(0.1f), shape = CircleShape)
                    .width(48.dp)
                    .height(48.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = data.image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .width(52.dp)
                        .height(52.dp)
                )
            }
            Spacer(modifier = Modifier.width(14.dp))
            Column() {
                Text(text = data.name, fontWeight = FontWeight.Bold, fontSize = 15.sp)
            }
        }


        Text(text = "${data.point} XP", color = Color(0xff279742), fontWeight = FontWeight.Bold)
    }
    Divider(
        thickness = 1.dp
    )
}
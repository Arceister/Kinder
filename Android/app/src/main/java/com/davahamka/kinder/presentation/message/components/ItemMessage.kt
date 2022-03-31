package com.davahamka.kinder.presentation.message.components

import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.davahamka.kinder.common.Screen
import com.davahamka.kinder.presentation.ui.theme.Grey1
import com.davahamka.kinder.static.Message

@Composable
fun ItemMessage(data: Message, navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth() .clickable { navController.navigate(Screen.MessageDetailScreen.route) },
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .height(64.dp)
                .padding(horizontal = 18.dp)
                .fillMaxWidth()
               ,
            verticalAlignment = Alignment.CenterVertically,
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
            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(text = data.name, fontSize = 14.sp)
                Text(text = data.text, color = Grey1, fontSize = 12.sp, modifier = Modifier.padding(vertical = 2.dp))
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
    }

    Divider(thickness = 1.dp)
}
package com.davahamka.kinder.presentation.home.components

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
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
import com.davahamka.kinder.presentation.ui.theme.*
import com.davahamka.kinder.static.Nearest

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemNearest(it: Nearest, onClick: ()-> Unit) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .height(120.dp),
        elevation = 2.dp,
        onClick = {
            onClick()
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.padding(14.dp)
            ) {
                AsyncImage(
                    model = it.imgUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .width(64.dp)
                        .height(64.dp)
                )
            }
            Column(
                modifier = Modifier.padding(top = 10.dp)
            ) {
                Text(text = it.title, color= Black1, fontWeight = FontWeight.Bold, fontSize = 15.sp, modifier = Modifier.padding(bottom = 2.dp))
                Text(text = it.name, color = Grey1, fontWeight = FontWeight.SemiBold, fontSize= 12.sp)
                Row(
                    modifier = Modifier.padding(top = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Filled.Star,
                        tint = Orange2,
                        contentDescription = null, modifier = Modifier.size(12.dp))
                    Text(text = it.rating.toString(), fontSize = 12.sp)
                    Text(text = it.location.toString(),fontSize = 12.sp, modifier = Modifier.padding(start = 12.dp))
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(top = 10.dp, bottom = 10.dp, end = 16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
                Box(modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(backgroundColorCondition(it.condition))){
                    Text(text = "${it.xp}XP", color = colorCondition(it.condition), fontWeight = FontWeight.SemiBold , modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 4.dp))
                }
                Text(text = "${it.condition} Condition", color = colorCondition(it.condition), fontWeight = FontWeight.SemiBold)
            }
        }
    }
    Spacer(modifier = Modifier.height(24.dp))
}

fun backgroundColorCondition(str: String): Color {
    if (str == "Good") {
        return Color(0XFF2F9A49).copy(0.2f)
    } else if(str == "Worth") {
        return Color(0xFFFC9E4F).copy(0.2f)
    }
    return White1
}

fun colorCondition(str: String): Color {
    if(str == "Good") {
        return Green3
    } else if (str == "Worth") {
        return Color(0xFFFC9E4F)
    }
    return White1
}
package com.davahamka.kinder.presentation.mission.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.provider.FontsContractCompat
import com.davahamka.kinder.R
import com.davahamka.kinder.presentation.ui.theme.Orange1
import com.davahamka.kinder.presentation.ui.theme.White1
import com.davahamka.kinder.static.MissionDetail
import com.davahamka.kinder.static.RecommendedMissionDataStatic

@Composable
fun MissionCard(data: MissionDetail) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = data.bgColor, shape = RoundedCornerShape(18.dp)),
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Column(
            modifier = Modifier.padding(start = 24.dp)
        ) {
            Row(
                modifier = Modifier
                    .background(color = Color(0xFFF8F8F8), shape = RoundedCornerShape(12.dp))
                    .padding(vertical = 6.dp, horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painter = if(data.type=="Donate") painterResource(id = R.drawable.ic_free) else painterResource(
                    id = R.drawable.ic_cheap_sale
                ), contentDescription = null, tint = Color(0xFF2A2B3C))
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = data.type, fontWeight = FontWeight.SemiBold)
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = data.imgMission), contentDescription = null)
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier
                    .background(color = Color(0xFFF8F8F8), shape = RoundedCornerShape(12.dp))
                    .padding(vertical = 8.dp, horizontal = 12.dp)
            ) {
                Text(text = "+${data.xp}xp", fontWeight = FontWeight.Bold, color = Orange1)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Text(text = data.title, fontWeight = FontWeight.Bold, fontSize = 22.sp, color = data.titleColor)
            Text(text = data.description, modifier = Modifier.padding(top = 14.dp), color = Color(0xFF565656))
        }

        Spacer(modifier = Modifier.height(48.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Filled.Person, contentDescription = null, modifier = Modifier.size(10.dp))
                Text(text = "500", fontWeight = FontWeight.Medium, fontSize = 12.sp)
                Text(text = " people have followed this", fontSize = 12.sp)
            }
            Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                backgroundColor = data.btnColor,
                contentColor = Color.White,
            ),
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier.height(34.dp)
            ) {
                Text(text = "Follow Now", fontSize = 11.sp)
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}
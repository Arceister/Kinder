package com.davahamka.kinder.presentation.home.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.davahamka.kinder.R
import com.davahamka.kinder.common.Screen
import com.davahamka.kinder.presentation.ui.theme.Grey1

@Composable
fun ModalBottomShare(navController: NavController?) {
    Column() {
        
    }
    Column(
        modifier = Modifier.padding(top = 24.dp, start = 24.dp, end = 24.dp, bottom = 32.dp)
    ) {
        Text(text = "Food Sharing Activities", fontWeight = FontWeight.Bold, fontSize = 14.sp, modifier = Modifier.padding(bottom = 26.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable {
                navController?.navigate(Screen.CameraScreen.route)
            }
        ) {
            Image(painter = painterResource(id = R.drawable.icon_donasi), contentDescription = null, modifier = Modifier.size(48.dp))
            Spacer(modifier = Modifier.width(12.dp))
            Column() {
                Text(text = "Donate", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(fontSize=12.sp,color= Grey1 , text = "Donate your excess and full of food to help our brothers in need")
            }
        }
        Divider(modifier = Modifier.padding(vertical = 14.dp).fillMaxWidth(),thickness = 1.dp)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.icon_obral), contentDescription = null, modifier = Modifier.size(48.dp))
            Spacer(modifier = Modifier.width(12.dp))
            Column() {
                Text(text = "Cheap Sale", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(fontSize=12.sp, color= Grey1 ,text = "Sell \u200B\u200Byour products that are not selling well in the market at prices that are more friendly to the small community")
            }
        }
    }
}
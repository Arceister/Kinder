package com.davahamka.kinder.presentation.home

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.davahamka.kinder.R
import com.davahamka.kinder.presentation.ui.theme.Orange1
import com.davahamka.kinder.presentation.ui.theme.Pink1
import com.davahamka.kinder.presentation.ui.theme.White1

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DonateOrReceiveButton(onClickDonate: ()->Unit, onClickReceive: ()->Unit) {
    Box(modifier = Modifier.padding(horizontal = 24.dp)){
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().padding(bottom = 14.dp)
        ) {
            Card(
                modifier = Modifier
                    .width(150.dp)
                    .height(110.dp),
                shape = RoundedCornerShape(16.dp),
                backgroundColor = Orange1,
                onClick = {onClickDonate()}
            ){
                Column(
                    modifier = Modifier.padding(14.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(painter = painterResource(id = R.drawable.vector), contentDescription = null, modifier = Modifier.size(32.dp))
                    Text(text = "Share Food", color = White1, fontWeight = FontWeight.Bold)
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Card(
                modifier = Modifier
                    .width(150.dp)
                    .height(110.dp),
                shape = RoundedCornerShape(16.dp),
                backgroundColor = Pink1,
                onClick = {onClickReceive()}
            ){
                Column(
                    modifier = Modifier.padding(14.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(painter = painterResource(id = R.drawable.ic_find_donate), contentDescription = null, modifier = Modifier.size(32.dp))
                    Text(text = "Find Food", color = White1, fontWeight = FontWeight.Bold)
                }
            }
        }
    } 
}
package com.davahamka.kinder.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.davahamka.kinder.R
import com.davahamka.kinder.common.Screen
import com.davahamka.kinder.presentation.ui.theme.PrimaryColor

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LevelCard(navController: NavController) {
    Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)) {
        Card(
            backgroundColor = Color.White,
            elevation = 3.dp,
            shape = RoundedCornerShape(12.dp),
            onClick = {
                navController.navigate(Screen.LevelScreen.route)
            }
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp, horizontal = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_level_icon),
                    contentDescription = null
                )
                Column() {
                    Text(
                        text = "100 xp to go to the next level",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Box(Modifier.padding(top = 4.dp)) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(8.dp)
                                .background(color = Color(0xFFC4C4C4))
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.6f)
                                .height(8.dp)
                                .background(color = PrimaryColor)
                        )
                    }
                }
                Icon(imageVector = Icons.Filled.ChevronRight, contentDescription = null)
            }
        }
    }
}
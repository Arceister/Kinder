package com.davahamka.kinder.presentation.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.davahamka.kinder.R
import com.davahamka.kinder.presentation.account.component.ItemMenuProfile
import com.davahamka.kinder.presentation.ui.component.BottomNavigationBar
import com.davahamka.kinder.presentation.ui.component.TopBarMission
import com.davahamka.kinder.presentation.ui.theme.Green3
import com.davahamka.kinder.presentation.ui.theme.Orange1
import com.davahamka.kinder.presentation.ui.theme.PrimaryColor
import com.davahamka.kinder.static.ListMenuAccountDataStatic


@Composable
fun AccountScreen(navController: NavController){
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) },
        topBar = { TopBarMission(title = "Profile")}
    ) {
        LazyColumn(modifier = Modifier.padding(horizontal = 24.dp)){
            item {
                Spacer(modifier = Modifier.height(32.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRo3Ft30HIpU684AfuuHsIB4wXud5WauxkWwQ&usqp=CAU",
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(CircleShape)
                            .width(140.dp)
                            .height(140.dp)
                    )
                    Text(text = "Billy Hafas", fontSize = 16.sp, modifier = Modifier.padding(top = 14.dp), fontWeight = FontWeight.Bold)
                    Row(
                        modifier = Modifier.padding(top=14.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_level_icon),
                                contentDescription = null,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Donate Warrior", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Color(0xFF565656))
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_level_icon),
                                contentDescription = null,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Food Waster Warrior", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Color(0xFF565656))
                        }
                    }
                }
                
                Text(text = "Total Impact", fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 18.dp), fontSize = 18.sp)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(120.dp)
                            .background(
                                color = Color(0xFFE8F2E4),
                                shape = RoundedCornerShape(10.dp)
                            ),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
//                        ic_img_impact_share
                        Image(painter = painterResource(id = R.drawable.ic_img_impact_share), contentDescription = null)
                        Text(text = "300", fontSize = 16.sp, color = Orange1, fontWeight = FontWeight.Bold)
                        Text(text = "Share Food", fontSize = 16.sp, color = Color(0xFF717171), fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(120.dp)
                            .background(
                                color = Color(0xFFF9EACD),
                                shape = RoundedCornerShape(10.dp)
                            ),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(painter = painterResource(id = R.drawable.ic_image_impact_saved), contentDescription = null)
                        Text(text = "270", fontSize = 16.sp, color = Green3, fontWeight = FontWeight.Bold)
                        Text(text = "Food Saved", fontSize = 16.sp, color = Color(0xFF717171), fontWeight = FontWeight.Bold)
                    }
                }


                Column(
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text(text = "Congratulations, in the last 30 days you have been a part of reducing food waste by 570 pieces")
                }

                Spacer(modifier = Modifier.height(12.dp))
                Button(onClick = {}, modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .border(width = 2.dp, color = PrimaryColor, shape = RoundedCornerShape(10.dp)),
                    colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = PrimaryColor,
                ),
                shape = RoundedCornerShape(10.dp),contentPadding = PaddingValues(vertical = 12.dp)) {
                    Text(text = "Share your impact now", fontWeight = FontWeight.SemiBold)
                }
                
                Spacer(modifier = Modifier.height(16.dp))

                Column(
                    modifier = Modifier.padding(bottom = 108.dp)
                ) {
                    ListMenuAccountDataStatic.dataCard.map {
                        ItemMenuProfile(text = it.text, image =it.image)
                    }
//                   ItemMenuProfile(text = "Demnm", image = )
                }

            }
        }
    }
}
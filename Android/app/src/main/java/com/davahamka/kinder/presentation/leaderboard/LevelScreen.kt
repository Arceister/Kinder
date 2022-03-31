package com.davahamka.kinder.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.davahamka.kinder.R
import com.davahamka.kinder.presentation.leaderboard.components.DonaturList
import com.davahamka.kinder.presentation.leaderboard.components.LevelList
import com.davahamka.kinder.presentation.ui.component.TopBarMission
import com.davahamka.kinder.presentation.ui.theme.Black1
import com.davahamka.kinder.presentation.ui.theme.Orange1
import com.davahamka.kinder.presentation.ui.theme.PrimaryColor
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun LevelScreen(navController: NavController) {
    val pagerState = rememberPagerState(initialPage = 0)
    Scaffold(
        topBar = { TopBarMission(title = "Level") }
    ) {
        LazyColumn() {
            item {
                Spacer(modifier = Modifier.height(32.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Column(
                        modifier = Modifier
                            .background(color = Color(0xFFFC9E4F), shape = CircleShape)
                            .padding(16.dp)
                    ) {
                        Image(painterResource(id = R.drawable.img_level_donatewarrior), contentDescription = null, modifier = Modifier.size(94.dp))
                    }
                    Text(text = "Donation Warrior", fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 6.dp))
                    Text(text = "Total points earned 700 XP", color = Orange1, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(top = 6.dp))
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = "100 XP to Donate Booster", color = Color(0xFF26730C), fontWeight = FontWeight.Bold)
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
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = "Start and go, follow the mission to reach 100 XP")
                    Spacer(modifier = Modifier.height(12.dp))
                    Column() {
                        Tabs(pagerState = pagerState)
                        TabsContent(pagerState = pagerState)
                    }
                }
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {
    var list = listOf("Donor", "Finder")
    var scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.White,
        contentColor = Color.White,
        divider = {
            TabRowDefaults.Divider(
                thickness = 2.dp,
                color = Color.White
            )
        },
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = PrimaryColor
            )
        }
    ) {
        list.forEachIndexed { index, _ ->
            Tab(
                text = {
                    Text(text = list[index], color = if (pagerState.currentPage == index) Black1 else Black1)
                },
                selected =pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(pagerState: PagerState) {
    HorizontalPager(state = pagerState, count = 2) { page ->
        when (page){
            0 -> LevelList()
            1 -> LevelList()
        }

    }
}
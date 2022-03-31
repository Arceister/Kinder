package com.davahamka.kinder.presentation.leaderboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.davahamka.kinder.presentation.leaderboard.components.DonaturList
import com.davahamka.kinder.presentation.ui.component.TopBarDescription
import com.davahamka.kinder.presentation.ui.theme.PrimaryColor
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun LeaderboardScreen(navController: NavController) {
    val pagerState = rememberPagerState(initialPage = 3)
    Scaffold(topBar = {
        TopBarDescription(title = "Leaderboard")
    }) {
        Column(
            modifier = Modifier.background(Color.White)
        ) {
            Tabs(pagerState = pagerState)
            TabsContent(pagerState = pagerState)
        }
    }
}

@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {
    var list = listOf("Donatur", "Pencari")
    var scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = PrimaryColor,
        contentColor = Color.White,
        divider = {
            TabRowDefaults.Divider(
                thickness = 2.dp,
                color = Color.Green
            )
        },
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = Color.White
            )
        }
    ) {
        list.forEachIndexed { index, _ -> 
            Tab(
                text = {
                Text(text = list[index], color = if (pagerState.currentPage == index) Color.White else Color.LightGray)
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
    HorizontalPager(state = pagerState, count = 3) { page ->
        when (page){
            0 -> DonaturList()
            1 -> DonaturList()
            2 -> DonaturList()
        }
        
    }
}
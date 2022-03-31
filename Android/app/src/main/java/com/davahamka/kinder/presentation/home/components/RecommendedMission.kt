package com.davahamka.kinder.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davahamka.kinder.presentation.auth.component.InformationCard
import com.davahamka.kinder.presentation.ui.theme.Black1
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun RecommendationMission() {
    val pagerState = rememberPagerState(1)
    Column(
        modifier = Modifier
            .padding(top = 32.dp, bottom = 12.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
    ) {
        
        Text(text = "Most Popular Mission Recommendations", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Black1)
        HorizontalPager(
            count = 3,
            state = pagerState,
            contentPadding = PaddingValues(20.dp),

            ) { page ->
           MissionCard(page)
        }
    }
}
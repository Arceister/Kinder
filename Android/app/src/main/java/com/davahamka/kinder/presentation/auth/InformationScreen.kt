package com.davahamka.kinder.presentation.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.davahamka.kinder.R
import com.davahamka.kinder.common.Navigation
import com.davahamka.kinder.common.Screen
import com.davahamka.kinder.presentation.auth.component.AuthenticationButton
import com.davahamka.kinder.presentation.auth.component.InformationCard
import com.davahamka.kinder.presentation.ui.theme.Black1
import com.davahamka.kinder.presentation.ui.theme.PrimaryColor
import com.davahamka.kinder.presentation.ui.theme.White1
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalPagerApi::class)
@Composable
fun InformationScreen(navController: NavController?) {
    val pagerState = rememberPagerState()
    val systemUiController = rememberSystemUiController()

    SideEffect {
        // Update all of the system bar colors to be transparent, and use
        // dark icons if we're in light theme
        systemUiController.setSystemBarsColor(
            color = White1,
        )

        // setStatusBarsColor() and setNavigationBarColor() also exist
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 32.dp,
                start = 16.dp,
                end = 16.dp
            ),
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.logo_kinder_primary),
                contentDescription = "logo kinder",
                modifier = Modifier.width(84.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

           
            HorizontalPager(
                count = 3,
                state = pagerState,
                contentPadding = PaddingValues(20.dp),

            ) { page ->
               InformationCard(
                   page = page
               )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    modifier = Modifier
                        .padding(16.dp),
                    activeColor = PrimaryColor,
                    inactiveColor = Color(0xFFD3D0D4),
                    )
            }



            Spacer(modifier = Modifier.height(14.dp))
            AuthenticationButton(
                text = "Login",
                onClick = {
                          navController?.navigate(Screen.LoginScreen.route)
                },
                )
            Row(
                modifier = Modifier.padding(top = 32.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Don't have an account yet? Please")
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Register",
                    style = TextStyle(PrimaryColor, fontWeight = FontWeight.SemiBold),
                    modifier = Modifier.clickable {
                        navController?.navigate(Screen.RegisterScreen.route)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun InformationScreenPreview(){
    Scaffold() {
        InformationScreen(null)
    }
}
package com.davahamka.kinder.presentation.ui.component

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.davahamka.kinder.presentation.ui.theme.Grey2
import com.davahamka.kinder.presentation.ui.theme.Grey3
import com.davahamka.kinder.presentation.ui.theme.PrimaryColor

@Composable
fun BottomNavigationBar(navController: NavController){
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Mission,
        NavigationItem.Message,
        NavigationItem.Account
    )

    BottomNavigation (
        backgroundColor = Color.White,
        contentColor = Grey3
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    if (currentRoute === item.route) Icon(painter = painterResource(id = item.iconSelected), contentDescription = item.title ) else Icon(painter =  painterResource(id = item.icon), contentDescription = item.title)
                },
                label = { Text(text = item.title) },
                onClick = {
                          navController.navigate(item.route) {
                              navController.graph.startDestinationRoute?.let { route ->
                                  popUpTo(route) {
                                      saveState = true
                                  }
                              }
                          }
                },
                selected = currentRoute == item.route,
                selectedContentColor = PrimaryColor,
                unselectedContentColor = Grey3,
            )
        }
    }
}

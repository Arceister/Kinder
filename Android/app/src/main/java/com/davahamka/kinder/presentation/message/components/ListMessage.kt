package com.davahamka.kinder.presentation.message.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.davahamka.kinder.static.messageDataStatic

@Composable
fun ListMessage(navContoller: NavController) {
    LazyColumn(
    ) {
        item {
            messageDataStatic.dataCard.forEach {
                ItemMessage(it, navController = navContoller)
            }
        }
    }
}
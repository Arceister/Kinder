package com.davahamka.kinder.presentation.donate.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ModalSelectDonationType() {
    LazyColumn {
        item {
            Row {
                Text(text = "Choose location")
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Change")
                }
            }

            Divider()

            Row() {
                Column() {
                    Text(text = "Jalan Bend Sigura-gura No.28")
                    Text(text = "Jalan Bend. Sigura-gura No.28, Kota Malang, Jawa Timur 65145 Indonesia ")
                }
            }
        }
    }
}
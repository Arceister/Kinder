package com.davahamka.kinder.presentation.donate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.davahamka.kinder.common.Screen
import com.davahamka.kinder.presentation.ui.component.TopBar
import com.davahamka.kinder.presentation.ui.component.TopBarDescription

@Composable
fun DescriptionFormScreen(navController: NavController, viewModel: DonateFormViewModel = hiltViewModel()) {
    Scaffold(
        topBar = { TopBarDescription(title = "Food Description") }
    ) {
        LazyColumn() {
            item {
                Column(
                    modifier = Modifier.padding(horizontal = 18.dp, vertical = 24.dp)
                ) {
                    Text(text = "Food Name")
                    OutlinedTextField(
                        value = viewModel.title,
                        onValueChange = {
                            viewModel.onEvent(DonateFormEvent.OnChangeTitle(it))
                        },
                        modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp) ,placeholder = {
                        Text("Type your food name here")
                    })
                    Text(text = "Description", modifier = Modifier.padding(top = 18.dp))
                    OutlinedTextField(
                        value = viewModel.description,
                        onValueChange = {
                                        viewModel.onEvent(DonateFormEvent.OnChangeDescription(it))
                        },
                        maxLines = 4,
                        singleLine = false,
                        modifier = Modifier
                        .fillMaxWidth()
                            .height(160.dp)
                        .padding(top = 12.dp), placeholder = {
                        Text(text = "Insert description")
                    })
                    Column(modifier = Modifier.padding(top = 64.dp)) {
                        CustomButton(text = "Continue", onClick = { navController.navigate(Screen.DonateMapScreen.route) })
                    }

                }

            }
        }
    }

}
package com.davahamka.kinder.presentation.message

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.AttachFile
import androidx.compose.material.icons.outlined.EmojiEmotions
import androidx.compose.material.icons.outlined.Link
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.davahamka.kinder.presentation.message.components.ReceiverBox
import com.davahamka.kinder.presentation.message.components.SenderBox
import com.davahamka.kinder.presentation.ui.component.TopBarMission

@Composable
fun MessageDetailScreen(navController: NavController) {
    Scaffold(
        topBar = { TopBarMission(title = "Yuli")},
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .padding(bottom = 12.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.padding(end = 12.dp),
                    leadingIcon = {
                        Icon(imageVector = Icons.Outlined.EmojiEmotions, contentDescription = null)
                    },
                    trailingIcon = {
                        Icon(imageVector = Icons.Outlined.AttachFile, contentDescription = null)
                    }
                    )
                Button(onClick = { }, shape = RoundedCornerShape(100.dp)) {
                    Icon(imageVector = Icons.Filled.Send, contentDescription = null)
                }
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            item {
                Spacer(modifier = Modifier.padding(top = 14.dp))
                SenderBox("Good Morning!")
                ReceiverBox("Good morning, is there anything I can help you with?")
            }
        }
    }
}
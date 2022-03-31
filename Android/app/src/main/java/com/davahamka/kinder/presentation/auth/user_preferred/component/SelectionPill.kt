package com.davahamka.kinder.presentation.auth.user_preferred.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.davahamka.kinder.R
import com.davahamka.kinder.presentation.ui.theme.Black1
import com.davahamka.kinder.presentation.ui.theme.Orange1

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SelectionPill(text: String, onClick: () -> Unit?, selected: Boolean = false) {
    Card(
        shape = RoundedCornerShape(20.dp),
        backgroundColor = if (selected) Orange1 else Color.White,
        elevation = 2.dp,
        onClick = { onClick() }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 12.dp),) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Plus", modifier = Modifier.size(14.dp), tint = if(selected) Color.White else Black1)
            Text(text = text, modifier = Modifier.padding(start = 2.dp), color = if(selected) Color.White else Black1)
        }
    }
}
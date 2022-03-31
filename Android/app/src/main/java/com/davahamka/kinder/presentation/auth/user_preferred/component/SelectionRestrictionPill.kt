package com.davahamka.kinder.presentation.auth.user_preferred.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.davahamka.kinder.presentation.ui.theme.Black1
import com.davahamka.kinder.presentation.ui.theme.Orange1

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SelectionRestrictionPill(text: String, onClick: () -> Unit?, selected: Boolean = false) {
    Card(
        shape = RoundedCornerShape(20.dp),
        backgroundColor = if (selected) Color(0XFFE66480) else Color.White,
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
package com.davahamka.kinder.presentation.donate

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.davahamka.kinder.presentation.ui.theme.PrimaryColor

@Composable
fun CustomButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier, isLoading: Boolean = false) {

    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = PrimaryColor,
            contentColor = Color.White
        ),
        contentPadding = PaddingValues(vertical = 12.dp),
        shape = RoundedCornerShape(25.dp),
    ) {
        if (isLoading) CircularProgressIndicator(color = Color.White, modifier = Modifier.size(18.dp),strokeWidth = 2.dp) else Text(text = text)
    }
}
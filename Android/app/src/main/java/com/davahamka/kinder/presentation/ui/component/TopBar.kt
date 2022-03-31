package com.davahamka.kinder.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.transform.CircleCropTransformation
import com.davahamka.kinder.presentation.ui.theme.Orange1
import com.davahamka.kinder.presentation.ui.theme.PrimaryColor
import com.davahamka.kinder.presentation.ui.theme.White1
import com.google.maps.android.compose.Circle

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .background(color = PrimaryColor)
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(64.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
//        Text(text = "100 point", color = White1)
//        Spacer(modifier = Modifier.width(4.dp))
//        CustomTextField(
//            leadingIcon = {
//                Icon(
//                    Icons.Filled.Search,
//                    null,
//                    tint = LocalContentColor.current.copy(alpha = 0.3f)
//                )
//            },
//            trailingIcon = null,
//            modifier = Modifier
//                .background(
//                    MaterialTheme.colors.surface,
//                    RoundedCornerShape(percent = 30)
//                )
//                .padding(4.dp)
//                .height(32.dp),
//            fontSize = 12.sp,
//            placeholderText = "Telusuri disini"
//        )
//        Spacer(modifier = Modifier.width(4.dp))
//        Text(text = "sss")
//        AsyncImage(
//            model = "https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50.jpg?s=120",
//            contentDescription = null,
//            modifier = Modifier.clip(CircleShape)
//        )
    }
}
package com.davahamka.kinder.presentation.auth.user_preferred

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.davahamka.kinder.common.Screen
import com.davahamka.kinder.presentation.auth.user_preferred.component.NextButton
import com.davahamka.kinder.presentation.auth.user_preferred.component.SelectionPill
import com.davahamka.kinder.presentation.auth.user_preferred.component.SelectionRestrictionPill
import com.davahamka.kinder.presentation.ui.theme.Black1
import com.davahamka.kinder.static.UserReferenceStatic
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun UserRestrictionScreen(
    navController: NavController?,
    viewModel: UserRestrictionViewModel = hiltViewModel()
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        item {
            Text(
                text = "Pilih bahan makanan yang jadi",
                color= Black1,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 88.dp)
            )
            Text(
                text = "pantangan kesehatanmu",
                color= Black1,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            )
            FlowRow(
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
                mainAxisSpacing = 12.dp,
                crossAxisSpacing = 16.dp
            ) {
                UserReferenceStatic.restrictionData.forEach {
                    if (viewModel.dataOptions.contains(it)){
                        SelectionRestrictionPill(text = it, onClick = {
                            viewModel.onEvent(UserRestrictionEvent.OnSelectOption(it))
                        },selected = true)
                    } else {
                        SelectionRestrictionPill(text = it, onClick = {
                            viewModel.onEvent(UserRestrictionEvent.OnSelectOption(it))
                        },selected = false)
                    }
                }
            }
        }
    }
    val constraints = ConstraintSet {
        val greenButton = createRefFor("greenButton")

        constrain(greenButton) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom, 52.dp)
        }
    }

    ConstraintLayout(
        constraints,
        modifier = Modifier.fillMaxSize()
    ) {


        NextButton(
            text = "Mulai Sekarang",
            onClick = { navController?.navigate(Screen.HomeScreen.route)  },
            modifier = Modifier.layoutId("greenButton")
        )
    }
}


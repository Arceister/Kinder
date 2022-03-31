package com.davahamka.kinder.presentation.donate

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DonateFormViewModel @Inject constructor(

): ViewModel() {

    var quantity by mutableStateOf("")
        private set

    var activityType by mutableStateOf("")
        private set

    var title by mutableStateOf("")
        private set

    var description by mutableStateOf("")
        private set

    fun onEvent(event: DonateFormEvent) {
        when(event) {
            is DonateFormEvent.OnChangeQuantity -> {
                quantity = event.quantity
            }
            is DonateFormEvent.OnChangeActivityType -> {
                activityType = event.activityType
            }
            is DonateFormEvent.OnChangeTitle -> {
                title = event.title
            }
            is DonateFormEvent.OnChangeDescription -> {
                description = event.description
            }
        }
    }
}
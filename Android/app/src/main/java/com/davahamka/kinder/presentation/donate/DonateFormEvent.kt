package com.davahamka.kinder.presentation.donate

sealed class DonateFormEvent {
    data class OnChangeQuantity(val quantity: String): DonateFormEvent()
    data class OnChangeActivityType(val activityType: String): DonateFormEvent()
    data class OnChangeTitle(val title: String): DonateFormEvent()
    data class OnChangeDescription(val description: String): DonateFormEvent()
}

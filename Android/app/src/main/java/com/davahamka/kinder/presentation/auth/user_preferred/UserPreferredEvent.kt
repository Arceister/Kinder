package com.davahamka.kinder.presentation.auth.user_preferred

sealed class UserPreferredEvent {
    object OnNextPage: UserPreferredEvent()
    data class OnSelectOption(val choose: String): UserPreferredEvent()
}

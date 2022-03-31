package com.davahamka.kinder.presentation.auth.user_preferred

sealed class UserRestrictionEvent {
    object OnNextPage: UserRestrictionEvent()
    data class OnSelectOption(val choose: String): UserRestrictionEvent()
}
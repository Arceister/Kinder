package com.davahamka.kinder.presentation.auth.login

data class LoginState(
    var isLoading: Boolean = false,
    var successMessage: String = "",
    var error: String = "",
)
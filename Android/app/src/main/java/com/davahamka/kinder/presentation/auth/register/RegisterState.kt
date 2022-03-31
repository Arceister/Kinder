package com.davahamka.kinder.presentation.auth.register

data class RegisterState(
    var isLoading: Boolean = false,
    var successMessage: String = "",
    var error: String = "",
)

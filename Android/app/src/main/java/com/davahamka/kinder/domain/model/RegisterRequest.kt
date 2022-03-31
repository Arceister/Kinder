package com.davahamka.kinder.domain.model

data class RegisterRequest (
    val email: String,
    val no_hp: String,
    val name: String,
    val password: String,
)
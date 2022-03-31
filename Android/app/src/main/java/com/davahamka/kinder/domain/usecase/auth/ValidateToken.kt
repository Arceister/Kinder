package com.davahamka.kinder.domain.usecase.auth

import com.davahamka.kinder.domain.repository.AuthRepository

class ValidateToken(private val repository: AuthRepository) {
    suspend operator fun invoke() {
        repository.validateToken()
    }
}
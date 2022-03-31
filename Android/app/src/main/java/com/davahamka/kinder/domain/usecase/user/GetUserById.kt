package com.davahamka.kinder.domain.usecase.user

import com.davahamka.kinder.domain.repository.UserRepository

class GetUserById (private val repository: UserRepository) {
    suspend operator fun invoke() {
        repository.getUserById()
    }
}
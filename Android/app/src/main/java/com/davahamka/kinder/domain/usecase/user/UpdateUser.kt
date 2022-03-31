package com.davahamka.kinder.domain.usecase.user

import com.davahamka.kinder.domain.repository.UserRepository

class UpdateUser(private val repository: UserRepository) {
    suspend fun invoke(updateUser: UpdateUser) {
        repository.updateUser()
    }
}
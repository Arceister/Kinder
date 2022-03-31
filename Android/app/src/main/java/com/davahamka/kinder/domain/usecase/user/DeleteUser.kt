package com.davahamka.kinder.domain.usecase.user

import com.davahamka.kinder.domain.repository.UserRepository

class DeleteUser(
    private val repository: UserRepository
) {
    suspend operator fun invoke(deleteUser: DeleteUser) {
        repository.deleteUser()
    }
}

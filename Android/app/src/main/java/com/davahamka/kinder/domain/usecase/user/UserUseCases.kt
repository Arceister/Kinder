package com.davahamka.kinder.domain.usecase.user

data class UserUseCases(
    val registerUser: RegisterUser,
    val updateUser: UpdateUser,
    val deleteUser: DeleteUser,
    val getUserById: GetUserById
)
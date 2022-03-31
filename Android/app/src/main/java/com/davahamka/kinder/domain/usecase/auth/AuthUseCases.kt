package com.davahamka.kinder.domain.usecase.auth

import com.davahamka.kinder.common.Resource
import com.davahamka.kinder.domain.model.LoginRequest
import com.davahamka.kinder.domain.model.LoginResponse
import com.davahamka.kinder.domain.usecase.user.RegisterUser
import kotlinx.coroutines.flow.Flow

data class AuthUseCases (
    val loginAuth: LoginAuth,
    val validateToken: ValidateToken
    )

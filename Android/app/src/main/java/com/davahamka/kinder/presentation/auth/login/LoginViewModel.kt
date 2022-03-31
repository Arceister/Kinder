package com.davahamka.kinder.presentation.auth.login

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davahamka.kinder.data.repository.AuthRepositoryImpl
import com.davahamka.kinder.domain.model.LoginRequest
import com.davahamka.kinder.domain.repository.AuthRepository
import com.davahamka.kinder.domain.usecase.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authUseCases: AuthUseCases
): ViewModel() {

    private var _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    var email by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    fun onEvent(event: LoginEvent) {
        when(event) {
            is LoginEvent.OnChangeEmail -> {
                email = event.email
            }
            is LoginEvent.OnChangePassword -> {
                password = event.password
            }
            is LoginEvent.NavigateToRegister -> {
                event.cb()
            }
            is LoginEvent.OnSubmitLogin -> {
                // TODO: Call API Login
                _state.value.isLoading = true
                Log.d("TES","LOGIN")
                if(email.isEmpty() || password.isEmpty()) {
                    return
                }
                viewModelScope.launch {
//                    try {
//                        authUseCases.loginAuth(LoginRequest(email, password)).collectLatest {
//                            Log.d("ddd", it.message ?: "login success"
//                            )
//                        }
//
//                    } catch (e: Exception) {
//                        Log.d("dww", e.message ?: "Error")
//                    }

                }
                event.cb()
            }
        }
    }
}
package com.davahamka.kinder.presentation.auth.register

import android.provider.ContactsContract
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davahamka.kinder.domain.model.RegisterRequest
import com.davahamka.kinder.domain.usecase.user.RegisterUser
import com.davahamka.kinder.domain.usecase.user.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCases: UserUseCases
): ViewModel() {

    private val _state = mutableStateOf(RegisterState())
    val state: State<RegisterState> = _state

    var name by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    var email by mutableStateOf("")
        private set

    var phoneNumber by mutableStateOf("")
        private set

    var isConfirmPrivacyPolicy by mutableStateOf(false)
        private set

    fun onEvent(event: RegisterEvent) {
        when(event) {
            is RegisterEvent.OnChangeName -> {
                name = event.name
            }
            is RegisterEvent.OnChangePassword -> {
                password = event.password
            }
            is RegisterEvent.OnChangeEmail -> {
                email = event.email
            }
            is RegisterEvent.OnChangePhoneNumber -> {
                phoneNumber = event.phoneNumber
            }
            is RegisterEvent.OnTogglePrivacyPolicy -> {
                isConfirmPrivacyPolicy = !isConfirmPrivacyPolicy
            }
            is RegisterEvent.OnSubmitRegister -> {
                Log.d("username", name)
                viewModelScope.apply {
                    _state.value = RegisterState(isLoading = true)
                }
                if (name.isBlank() || password.isBlank() || email.isBlank() || phoneNumber.isBlank()) {
                    viewModelScope.launch {
                        registerUseCases.registerUser(
                            RegisterRequest(email = email, name = name, no_hp = phoneNumber, password = password)
                        )
                    }

                }
            }
            is RegisterEvent.NavigateToLogin -> {
                event.cb()
            }
        }
    }
}
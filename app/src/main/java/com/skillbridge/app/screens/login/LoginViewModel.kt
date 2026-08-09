package com.skillbridge.app.screens.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun onEmailChange(email: String) {
        _uiState.update {
            it.copy(email = email,
                emailError = null
                )
        }
    }

    fun onPasswordChange(password: String) {
        _uiState.update {
            it.copy(password = password,
                passwordError = null
                )
        }
    }
    fun onLoginClick() {
        if (_uiState.value.email.isBlank()) {
            _uiState.update {
                it.copy(
                    emailError = "Email is required"
                )
            }
            return
        }
        if(_uiState.value.password.isBlank()){
            _uiState.update {
                it.copy(
                    passwordError = "Password is  required"
                )
            }
            return
        }
    }

}
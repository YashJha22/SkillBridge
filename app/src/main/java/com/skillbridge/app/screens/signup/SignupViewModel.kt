package com.skillbridge.app.screens.signup

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignupViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SignupUiState())

    val uiState: StateFlow<SignupUiState> = _uiState.asStateFlow()

    fun onFullNameChange(value: String) {
        _uiState.value = _uiState.value.copy(
            fullName = value
        )
    }

    fun onEmailChange(value: String) {
        _uiState.value = _uiState.value.copy(
            email = value
        )
    }

    fun onPasswordChange(value: String) {
        _uiState.value = _uiState.value.copy(
            password = value
        )
    }

    fun onConfirmPasswordChange(value: String) {
        _uiState.value = _uiState.value.copy(
            confirmPassword = value
        )
    }

    fun onRoleSelected(role: SignupRole) {
        _uiState.value = _uiState.value.copy(
            role = role
        )
    }

    fun onSkillSelected(skill: String) {
        val currentSkills = _uiState.value.selectedSkills

        if (skill in currentSkills) {
            _uiState.value = _uiState.value.copy(
                selectedSkills = currentSkills - skill
            )
            return
        }

        if (currentSkills.size >= 3) {
            return
        }

        _uiState.value = _uiState.value.copy(
            selectedSkills = currentSkills + skill
        )
    }

    fun onCreateAccountClick() {
        val state = _uiState.value

        val fullNameError = if (state.fullName.isBlank()) {
            "Full name is required"
        } else {
            null
        }

        val emailError = if (
            state.email.isBlank() ||
            !android.util.Patterns.EMAIL_ADDRESS
                .matcher(state.email)
                .matches()
        ) {
            "Enter a Valid Email"
        } else {
            null
        }

        val passwordError = if (state.password.length < 8) {
            "Password must be at least 8 characters"
        } else {
            null
        }

        val confirmPasswordError = if (
            state.confirmPassword != state.password
        ) {
            "Passwords do not match"
        } else {
            null
        }

        _uiState.value = state.copy(
            fullNameError = fullNameError,
            emailError = emailError,
            passwordError = passwordError,
            confirmPasswordError = confirmPasswordError
        )
    }
}

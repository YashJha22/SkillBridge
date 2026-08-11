package com.skillbridge.app.screens.signup

data class SignupUiState(
    val fullName: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",

    val role: SignupRole? = null,
    val selectedSkills: Set<String> = emptySet(),

    val fullNameError: String? = null,
    val emailError: String? = null,
    val passwordError: String? = null,
    val confirmPasswordError: String? = null,

    val isLoading: Boolean = false,
    val isSuccess: Boolean = false
)
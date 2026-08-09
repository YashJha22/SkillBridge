package com.skillbridge.app.screens.login


data class LoginUiState(
    val email: String = "",
    val password: String ="",
    val emailError: String? = null,
    val passwordError: String? = null

)
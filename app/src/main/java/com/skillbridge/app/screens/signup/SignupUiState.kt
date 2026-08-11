package com.skillbridge.app.screens.signup

data class SignupUiState(
    val fullName: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",

    val role: SignupRole? = null,
    val selectedSkills: Set<String> = emptySet(),

    val bio: String ="",
    val github: String ="",
    val portfolio: String ="",

    val companyName: String ="",
    val hiringDescription: String ="",

    val fullNameError: String? = null,
    val emailError: String? = null,
    val passwordError: String? = null,
    val confirmPasswordError: String? = null,
    val bioError: String? = null,
    val camponyNameError: String? = null,
    val hiringDescriptionError: String? = null,

    val isLoading: Boolean = false,
    val isSuccess: Boolean = false
)
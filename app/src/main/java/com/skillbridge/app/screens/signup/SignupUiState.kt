package com.skillbridge.app.screens.signup

data class SignupUiState(

    // Step 1
    val fullName: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",

    val fullNameError: String? = null,
    val emailError: String? = null,
    val passwordError: String? = null,
    val confirmPasswordError: String? = null,

    // Step 2
    val role: SignupRole? = null,
    val selectedSkills: Set<String> = emptySet(),

    // Step 3 - Freelancer
    val bio: String = "",
    val github: String = "",
    val portfolio: String = "",

    val bioError: String? = null,

    // Step 3 - Company
    val companyName: String = "",
    val hiringDescription: String = "",

    val companyNameError: String? = null,
    val hiringDescriptionError: String? = null
)
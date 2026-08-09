package com.skillbridge.app.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.skillbridge.app.screens.components.LoginForm
import com.skillbridge.app.screens.components.LogoSection
import com.skillbridge.app.screens.components.WelcomeSection

@Composable
fun LoginScreen(onSignUpClick: ()-> Unit) {


    val viewModel: LoginViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(
                horizontal = 24.dp,
                vertical = 24.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LogoSection()

        Spacer(modifier = Modifier.height(32.dp))

        WelcomeSection(
            title = "The legend returns! ",
            subtitle = "Show me your hall pass."
        )

        Spacer(modifier = Modifier.height(24.dp))

        LoginForm(
            email = uiState.email,
            password = uiState.password,
            emailError =uiState.emailError,
            passwordError = uiState.passwordError,
            onEmailChange = viewModel::onEmailChange,
            onPasswordChange = viewModel::onPasswordChange,
            onLoginClick = viewModel::onLoginClick,
            onSignUpClick = onSignUpClick
        )
    }
}
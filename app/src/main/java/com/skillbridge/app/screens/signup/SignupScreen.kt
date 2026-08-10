package com.skillbridge.app.screens.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.skillbridge.app.screens.components.AuthFooter
import com.skillbridge.app.screens.components.LogoSection
import com.skillbridge.app.screens.components.SkillBridgeTextField
import com.skillbridge.app.screens.components.SocialLoginSection
import com.skillbridge.app.screens.components.WelcomeSection

@Composable
fun SignupScreen(
    onBackToLoginClick: () -> Unit
) {

    val viewModel: SignupViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(
                horizontal = 20.dp,
                vertical = 30.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LogoSection()

        Spacer(
            modifier = Modifier.height(36.dp)
        )

        WelcomeSection(
            title = "Begin your origin story",
            subtitle = "Stop waiting, start bridging"
        )

        Spacer(
            modifier = Modifier.height(28.dp)
        )

        SkillBridgeTextField(
            value = uiState.fullName,
            onValueChange = viewModel::onFullNameChange,
            label = "Full Name",
            placeholder = "Enter your full name",
            error = uiState.fullNameError
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        SkillBridgeTextField(
            value = uiState.email,
            onValueChange = viewModel::onEmailChange,
            label = "Email",
            placeholder = "you@example.com",
            error = uiState.emailError
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        SkillBridgeTextField(
            value = uiState.password,
            onValueChange = viewModel::onPasswordChange,
            label = "Password",
            placeholder = "••••••••",
            isPassword = true,
            error = uiState.passwordError
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        SkillBridgeTextField(
            value = uiState.confirmPassword,
            onValueChange = viewModel::onConfirmPasswordChange,
            label = "Confirm Password",
            placeholder = "••••••••",
            isPassword = true,
            error = uiState.confirmPasswordError
        )

        Spacer(
            modifier = Modifier.height(28.dp)
        )

        Button(
            onClick = viewModel::onCreateAccountClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = "Get on the bridge.",
                style = MaterialTheme.typography.titleMedium
            )
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            HorizontalDivider(
                modifier = Modifier.weight(1f),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.outline
            )

            Text(
                text = " OR ",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            HorizontalDivider(
                modifier = Modifier.weight(1f),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.outline
            )
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        SocialLoginSection()

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        AuthFooter(
            isSignup = true,
            onClick = onBackToLoginClick
        )
    }
}
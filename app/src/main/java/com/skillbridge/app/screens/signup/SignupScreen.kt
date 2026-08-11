package com.skillbridge.app.screens.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.skillbridge.app.screens.components.AuthFooter
import com.skillbridge.app.screens.components.LogoSection
import com.skillbridge.app.screens.components.SkillBridgeTextField
import com.skillbridge.app.screens.components.SocialLoginSection
import com.skillbridge.app.screens.components.WelcomeSection

@Composable
fun SignupScreen(
    navController: NavHostController
) {
    val viewModel: SignupViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp)
                .padding(
                    top = 0.dp,
                    bottom = 8.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // SkillBridge logo
            LogoSection()

            // Small gap between logo and step indicator
            Spacer(
                modifier = Modifier.height(4.dp)
            )

            // Step indicator
            Text(
                text = "STEP 1 OF 3",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.labelSmall.copy(
                    letterSpacing = 2.sp
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            // Signup heading
            WelcomeSection(
                title = "Begin your origin story",
                subtitle = "Stop waiting, start bridging"
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            // Full Name
            SkillBridgeTextField(
                value = uiState.fullName,
                onValueChange = viewModel::onFullNameChange,
                label = "Full Name",
                placeholder = "Enter your full name",
                error = uiState.fullNameError
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            // Email
            SkillBridgeTextField(
                value = uiState.email,
                onValueChange = viewModel::onEmailChange,
                label = "Email",
                placeholder = "you@example.com",
                error = uiState.emailError
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            // Password
            SkillBridgeTextField(
                value = uiState.password,
                onValueChange = viewModel::onPasswordChange,
                label = "Password",
                placeholder = "••••••••",
                isPassword = true,
                error = uiState.passwordError
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            // Confirm Password
            SkillBridgeTextField(
                value = uiState.confirmPassword,
                onValueChange = viewModel::onConfirmPasswordChange,
                label = "Confirm Password",
                placeholder = "••••••••",
                isPassword = true,
                error = uiState.confirmPasswordError
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            // Create Account
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
                modifier = Modifier.height(12.dp)
            )

            // OR divider
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
                modifier = Modifier.height(12.dp)
            )

            // Google / GitHub / Discord
            SocialLoginSection()

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            // Already have an account?
            AuthFooter(
                isSignup = true
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )
        }

        // Back arrow
        // Independent from the Column.
        IconButton(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(
                    start = 8.dp,
                    top = 8.dp
                )
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back to Login",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
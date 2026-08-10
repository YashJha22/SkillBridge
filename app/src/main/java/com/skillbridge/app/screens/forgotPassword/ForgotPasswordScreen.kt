package com.skillbridge.app.screens.forgotPassword

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skillbridge.app.screens.components.LogoSection
import com.skillbridge.app.screens.components.SkillBridgeTextField
import com.skillbridge.app.screens.components.WelcomeSection

@Composable
fun ForgetPassword(
    onBackToLoginClick: () -> Unit
) {

    var email by remember {
        mutableStateOf("")
    }

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

        Spacer(
            modifier = Modifier.height(40.dp)
        )

        WelcomeSection(
            title = "Misplaced your credentials, \nsoldier?",
            subtitle = "Enter your email to reset your password.",
            titleFontSize = 24.sp
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        SkillBridgeTextField(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            placeholder = "you@gmail.com"
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = "Send Reset Link",
                style = MaterialTheme.typography.titleMedium
            )
        }

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        TextButton(
            onClick = onBackToLoginClick
        ) {
            Text(
                text = "Back to Login",
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
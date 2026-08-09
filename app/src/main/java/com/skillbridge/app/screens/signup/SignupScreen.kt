package com.skillbridge.app.screens.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.skillbridge.app.screens.components.LogoSection
import com.skillbridge.app.screens.components.SkillBridgeTextField
import com.skillbridge.app.screens.components.SocialLoginSection
import com.skillbridge.app.screens.components.WelcomeSection
import com.skillbridge.app.screens.components.AuthFooter

@Composable
fun SignupScreen() {

    var fullName by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var confirmPassword by remember {
        mutableStateOf("")
    }

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
            modifier = Modifier.height(32.dp)
        )

        WelcomeSection(
            title = "Begin your origin story",
            subtitle = "Stop waiting, start bridging"
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        SkillBridgeTextField(
            value = fullName,
            onValueChange = { fullName = it },
            label = "Full Name",
            placeholder = "Enter your full name"
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        SkillBridgeTextField(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            placeholder = "you@example.com"
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        SkillBridgeTextField(
            value = password,
            onValueChange = { password = it },
            label = "Password",
            placeholder = "••••••••",
            isPassword = true
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        SkillBridgeTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = "Confirm Password",
            placeholder = "••••••••",
            isPassword = true
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = { },
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
            isSignup = true
        )
    }
}
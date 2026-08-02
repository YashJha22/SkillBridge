package com.skillbridge.app.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.skillbridge.app.R

@Composable
fun SocialLoginSection(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        // Google
        SocialLogoButton(
            icon = R.drawable.google_logo,
            contentDescription = "Sign in with Google",
            onClick = { /* TODO: Google Sign-In */ }
        )

        Spacer(modifier = Modifier.width(16.dp))

        // GitHub
        SocialLogoButton(
            icon = R.drawable.github_logo,
            contentDescription = "Sign in with GitHub",
            onClick = { /* TODO: GitHub Sign-In */ }
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Discord
        SocialLogoButton(
            icon = R.drawable.discord_logo,
            contentDescription = "Sign in with Discord",
            onClick = { /* TODO: Discord Sign-In */ }
        )
    }
}
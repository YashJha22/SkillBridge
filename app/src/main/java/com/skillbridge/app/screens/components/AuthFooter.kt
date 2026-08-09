package com.skillbridge.app.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun AuthFooter(
    isSignup: Boolean = false,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = if (isSignup) {
                "Already have an account?"
            } else {
                "Don't have an account?"
            },
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        TextButton(
            onClick = onClick
        ) {
            Text(
                text = if (isSignup) {
                    "Login"
                } else {
                    "Sign Up"
                },
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
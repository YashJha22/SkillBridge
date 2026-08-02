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
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Don't have an account?",
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        TextButton(
            onClick = { /* TODO: Navigate to Sign Up */ }
        ) {
            Text(
                text = "Sign Up",
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
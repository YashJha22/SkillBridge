package com.skillbridge.app.screens.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.skillbridge.app.screens.components.SkillBridgeTextField

@Composable
fun ProfileScreen(
    viewModel: SignupViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState.role) {
        SignupRole.EARN -> {
            EarnProfileForm(
                viewModel = viewModel,
                uiState = uiState
            )
        }

        SignupRole.HIRE -> {
            // Company profile
        }

        null -> {
            // No role selected
        }
    }
}

@Composable
private fun EarnProfileForm(
    viewModel: SignupViewModel,
    uiState: SignupUiState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(
                horizontal = 20.dp,
                vertical = 28.dp
            )
    ) {
        Text(
            text = "STEP 3 OF 3",
            style = MaterialTheme.typography.labelSmall.copy(
                letterSpacing = 2.sp
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
            text = "Profile",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Normal
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        Text(
            text = "FREELANCER PROFILE",
            style = MaterialTheme.typography.labelMedium.copy(
                letterSpacing = 2.sp
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text ="Profile Picture",
            style= MaterialTheme.typography.labelMedium.copy(
                letterSpacing = 2.sp
            ),
              color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer (
            modifier = Modifier.height(12.dp)
        )

        Surface(
            modifier = Modifier
                .size(96.dp)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = CircleShape
                ),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.surfaceVariant
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "+",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(modifier = Modifier.height(28.dp)
            )
            SkillBridgeTextField(
                value = uiState.bio,
                onValueChange = viewModel::onBioChange,
                label = "Short bio/ headline",
                placeholder = "eg. Android developer build mobile experiences",
                error = uiState.bioError,
                singleLine = false
            )
        }
    }
}
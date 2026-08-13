package com.skillbridge.app.screens.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
    onContinueClick: () -> Unit = {},
    viewModel: SignupViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState.role) {

        SignupRole.EARN -> {
            EarnProfileForm(
                viewModel = viewModel,
                uiState = uiState,
                onContinueClick = onContinueClick
            )
        }

        SignupRole.HIRE -> {
            // Company profile will be implemented next.
        }

        null -> {
            // No role selected.
        }
    }
}

@Composable
private fun EarnProfileForm(
    viewModel: SignupViewModel,
    uiState: SignupUiState,
    onContinueClick: () -> Unit
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
            text = "PROFILE PICTURE",
            style = MaterialTheme.typography.labelMedium.copy(
                letterSpacing = 2.sp
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(
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
        }

        Spacer(
            modifier = Modifier.height(28.dp)
        )

        SkillBridgeTextField(
            value = uiState.bio,
            onValueChange = viewModel::onBioChange,
            label = "Short bio / headline",
            placeholder = "e.g. Android developer building mobile experiences",
            error = uiState.bioError,
            singleLine = false
        )

        Spacer(
            modifier = Modifier.height(28.dp)
        )

        SkillBridgeTextField(
            value = uiState.github,
            onValueChange = viewModel::onGithubChange,
            label = "GitHub",
            placeholder = "github.com/username"
        )

        Spacer(
            modifier = Modifier.height(28.dp)
        )

        SkillBridgeTextField(
            value = uiState.portfolio,
            onValueChange = viewModel::onPortfolioChange,
            label = "Portfolio / past work",
            placeholder = "Link to your work"
        )

        Spacer(
            modifier = Modifier.height(36.dp)
        )

        Button(
            onClick = {
                if (viewModel.onEarnProfileContinueClick()) {
                    onContinueClick()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Text(
                text = "ENTER SKILLBRIDGE",
                style = MaterialTheme.typography.labelLarge.copy(
                    letterSpacing = 1.5.sp
                )
            )
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )
    }
}
package com.skillbridge.app.screens.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
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
import com.skillbridge.app.screens.components.WelcomeSection

@Composable
fun SignupScreen( ){
    var fullName by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 20.dp, vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LogoSection( )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        WelcomeSection(
            title = "Begin your origin story" ,
            subtitle = "Stop waiting, start bridging"
        )
        Spacer (
            modifier = Modifier.height(24.dp)
        )
        SkillBridgeTextField(
            value = fullName,
            onValueChange = {fullName = it},
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
    }

}
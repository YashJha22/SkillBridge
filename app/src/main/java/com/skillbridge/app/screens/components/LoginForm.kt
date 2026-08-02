package com.skillbridge.app.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginForm(
    modifier: Modifier = Modifier
) {
    //state of email and password
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        //Email Field
        SkillBridgeTextField(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            placeholder ="Enter Your email"
        )

        Spacer(modifier = Modifier.height(12.dp))

        //Password Field
        SkillBridgeTextField(
            value = password,
            onValueChange = { password = it },
            label = "Password",
            placeholder = "Enter your password"
        )

    }

}
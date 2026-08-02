package com.skillbridge.app.screens.components


import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SkillBridgeTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String ="",
    singleLine: Boolean = true,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label ={ Text(label) },
        placeholder ={Text("Enter Your Email")},
        singleLine = singleLine,
        modifier = modifier
    )
}
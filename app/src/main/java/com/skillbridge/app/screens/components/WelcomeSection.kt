package com.skillbridge.app.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeSection(
    modifier: Modifier = Modifier
){
    Column(
        modifier = Modifier
    ){
        Text(
            text ="Welcome Back!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier= Modifier.height(4.dp))

        Text(
            text ="Login to continue your journey",
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
package com.skillbridge.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.skillbridge.app.navigation.AppNavigation
import com.skillbridge.app.ui.theme.SkillBridgeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            SkillBridgeTheme {
                AppNavigation()
            }
        }
    }
}
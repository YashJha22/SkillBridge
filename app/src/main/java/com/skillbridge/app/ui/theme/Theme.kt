package com.skillbridge.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val SkillBridgeDarkColorScheme = darkColorScheme(

    // Brand
    primary = Gold,
    onPrimary = Background,

    secondary = Sage,
    onSecondary = Background,

    tertiary = GoldDim,
    onTertiary = Ivory,

    // Background
    background = Background,
    onBackground = Ivory,

    // Surfaces
    surface = Surface,
    onSurface = Ivory,

    surfaceVariant = SurfaceRaised,
    onSurfaceVariant = IvoryDim,

    // Borders
    outline = Hairline,
    outlineVariant = HairlineSoft,

    // Errors (Material default)
    error = androidx.compose.ui.graphics.Color(0xFFCF6679),
    onError = androidx.compose.ui.graphics.Color.White,
    errorContainer = androidx.compose.ui.graphics.Color(0xFFB3261E),
    onErrorContainer = androidx.compose.ui.graphics.Color.White,

    // Misc
    inverseSurface = Ivory,
    inverseOnSurface = Background,
    inversePrimary = Gold
)

@Composable
fun SkillBridgeTheme(
    darkTheme: Boolean = true,   // Dark-first app
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = SkillBridgeDarkColorScheme,
        typography = Typography,
        content = content
    )
}
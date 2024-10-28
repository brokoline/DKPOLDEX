package com.example.folkedex.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFFF6F61),
    secondary = Color(0xFFBDBDBD),
    tertiary = Color(0xFFE91E63)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFFF6F61),
    secondary = Color(0xFFBDBDBD),
    tertiary = Color(0xFFE91E63)
)

@Composable
fun FolkeDexTheme(
    darkTheme: Boolean = false, // evt. brug dynamisk tema baseret på systemet
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

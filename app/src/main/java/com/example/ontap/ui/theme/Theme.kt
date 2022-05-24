package com.example.ontap.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Floral,
    primaryVariant = White,
    secondary = OldSilver,
    secondaryVariant = SonicSilver,
    background = EerieBlack,
    onPrimary = EerieBlack,
    onSecondary = White,
    onBackground = White
)

@Composable
fun OnTapTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = DarkColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
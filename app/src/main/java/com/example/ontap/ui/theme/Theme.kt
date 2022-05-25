package com.example.ontap.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

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
    val systemUiController = rememberSystemUiController()

    systemUiController.setStatusBarColor(DarkColorPalette.background, false)
    systemUiController.setNavigationBarColor(DarkColorPalette.primary, false)

    MaterialTheme(
        colors = DarkColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
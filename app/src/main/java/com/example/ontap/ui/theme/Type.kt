package com.example.ontap.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ontap.R

val Typography = Typography(
    defaultFontFamily = FontFamily(
        fonts = listOf(
            Font(R.font.roboto_light),
            Font(R.font.roboto_regular),
            Font(R.font.roboto_medium)
        )
    ),
    h1 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 96.sp
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    ),
    subtitle2 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 12.sp
    )
)
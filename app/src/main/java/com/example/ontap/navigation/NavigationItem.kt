package com.example.ontap.navigation

import androidx.annotation.DrawableRes

internal data class NavigationItem(
    val route: String,
    @DrawableRes val icon: Int,
    val name: String
)

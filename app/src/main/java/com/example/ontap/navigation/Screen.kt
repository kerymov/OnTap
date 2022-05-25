package com.example.ontap.navigation

internal sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object SolvesScreen : Screen("solves_screen")
    object ResultsScreen : Screen("results_screen")
}

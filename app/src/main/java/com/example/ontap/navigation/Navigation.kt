package com.example.ontap.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
internal fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {

        }
        composable(route = Screen.SolvesScreen.route) {

        }
        composable(route = Screen.ResultsScreen.route) {

        }
    }
}
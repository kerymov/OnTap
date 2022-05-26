package com.example.ontap.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ontap.screens.TimerScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun Navigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route,
        modifier = modifier
    ) {
        composable(route = Screen.MainScreen.route) {
            TimerScreen(modifier = Modifier.fillMaxSize())
        }
        composable(route = Screen.SolvesScreen.route) {

        }
        composable(route = Screen.ResultsScreen.route) {

        }
    }
}
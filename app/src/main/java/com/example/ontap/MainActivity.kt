package com.example.ontap

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ontap.navigation.Navigation
import com.example.ontap.navigation.NavigationItem
import com.example.ontap.navigation.Screen
import com.example.ontap.components.BottomNavigationBar
import com.example.ontap.components.TopBar
import com.example.ontap.ui.theme.OnTapTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnTapTheme {
                val navController = rememberNavController()
                Content(
                    navController = navController,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun Content(
    navController: NavHostController,
    modifier: Modifier
) = Scaffold(
    topBar = {
        TopBar(
            eventLabel = "3x3 cube",
            onSelectEventButtonClick = { /*TODO*/ }
        )
    },
    bottomBar = {
        BottomNavigationBar(
            items = listOf(
                NavigationItem(
                    route = Screen.MainScreen.route,
                    icon = R.drawable.ic_clock,
                    name = "Timer"
                ),
                NavigationItem(
                    route = Screen.SolvesScreen.route,
                    icon = R.drawable.ic_list,
                    name = "Solves"
                ),
                NavigationItem(
                    route = Screen.ResultsScreen.route,
                    icon = R.drawable.ic_chart,
                    name = "Results"
                )
            ),
            navController = navController,
            onItemClick = {
                navController.navigate(it.route)
            },
            modifier = Modifier
                .clip(MaterialTheme.shapes.large)
        )
    },
    modifier = modifier
) {
    Navigation(
        navController = navController,
        modifier = Modifier.padding(it)
    )
}
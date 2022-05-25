package com.example.ontap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ontap.navigation.Navigation
import com.example.ontap.navigation.NavigationItem
import com.example.ontap.navigation.Screen
import com.example.ontap.navigation.components.BottomNavigationBar
import com.example.ontap.ui.theme.OnTapTheme

class MainActivity : ComponentActivity() {
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

@Composable
private fun Content(
    navController: NavHostController,
    modifier: Modifier
) = Scaffold(
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
    Navigation(navController = navController)
}
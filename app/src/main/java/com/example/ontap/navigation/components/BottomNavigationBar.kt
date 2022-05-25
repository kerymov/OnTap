package com.example.ontap.navigation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.ontap.navigation.NavigationItem

@Composable
internal fun BottomNavigationBar(
    items: List<NavigationItem>,
    navController: NavController,
    onItemClick: (NavigationItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.primary,
    ) {
        items.forEach { item ->
            val isSelected = item.route == backStackEntry?.destination?.route
            BottomNavigationItem(
                selected = isSelected,
                onClick = { onItemClick(item) },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.name,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = {
                    Text(
                        text = item.name,
                        style = MaterialTheme.typography.caption.copy(
                            fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal
                        )
                    )
                },
                selectedContentColor = MaterialTheme.colors.primaryVariant,
                unselectedContentColor = contentColorFor(MaterialTheme.colors.primary)
            )
        }
    }
}

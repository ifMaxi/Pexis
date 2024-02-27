package com.maxidev.pexis.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.maxidev.pexis.ui.presentation.home.PhotosScreen
import com.maxidev.pexis.ui.presentation.search.SearchScreen
import com.maxidev.pexis.ui.theme.poppinsFamily

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: Destinations = Destinations.Home
) {
    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = modifier,
                tonalElevation = NavigationBarDefaults.Elevation
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                val items = listOf(
                    Destinations.Home,
                    Destinations.Search
                )

                items.forEach { screen ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any {
                            it.route == screen.route
                        } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                               Image(
                                   painter = painterResource(id = screen.icon),
                                   contentDescription = null,
                                   modifier = Modifier
                                       .size(25.dp)
                               )
                        },
                        label = {
                            Text(
                                text = stringResource(id = screen.name),
                                fontFamily = poppinsFamily
                            )
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            modifier = modifier.padding(paddingValues),
            navController = navController,
            startDestination = startDestination.route
        ) {
            composable(route = startDestination.route) {
                PhotosScreen()
            }
            composable(route = Destinations.Search.route) {
                SearchScreen()
            }
        }
    }
}
package com.maxidev.pexis.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maxidev.pexis.ui.presentation.components.PexelsPhotoProviderComponent
import com.maxidev.pexis.ui.presentation.home.PhotosScreen
import com.maxidev.pexis.ui.presentation.search.SearchScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: Destinations = Destinations.Home
) {
    Scaffold(
        bottomBar = {
            PexelsPhotoProviderComponent()
        }
    ) { paddingValues ->
        NavHost(
            modifier = modifier
                .padding(paddingValues),
            navController = navController,
            startDestination = startDestination.route
        ) {
            composable(route = startDestination.route) {
                PhotosScreen(
                    onNavigate = {
                        navController.navigate(Destinations.Search.route) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
            composable(route = Destinations.Search.route) {
                SearchScreen()
            }
        }
    }
}
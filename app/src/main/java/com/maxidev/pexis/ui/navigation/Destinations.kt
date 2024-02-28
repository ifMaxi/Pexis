package com.maxidev.pexis.ui.navigation

sealed class Destinations(val route: String) {
    data object Home: Destinations(route = "home")
    data object Search: Destinations(route = "search")
}
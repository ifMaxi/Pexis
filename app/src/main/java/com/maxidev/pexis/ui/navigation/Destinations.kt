package com.maxidev.pexis.ui.navigation

import androidx.annotation.StringRes
import com.maxidev.pexis.R

sealed class Destinations(
    val route: String,
    @StringRes val name: Int,
    val icon: Int,
) {
    data object Home: Destinations(
        route = "home",
        name = R.string.home_screen,
        icon = R.drawable.home
    )
    data object Search: Destinations(
        route = "search",
        name = R.string.search_screen,
        icon = R.drawable.search
    )
}
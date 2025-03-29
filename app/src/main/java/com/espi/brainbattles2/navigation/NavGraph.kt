package com.espi.brainbattles2.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Game : Screen("game")
    object Settings : Screen("settings")
}

object NavGraph {
    const val ROOT_ROUTE = "root"
} 
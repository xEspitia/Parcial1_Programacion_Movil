package com.espi.brainbattles2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.livedata.observeAsState
import com.espi.brainbattles2.navigation.Screen
import com.espi.brainbattles2.ui.screens.GameScreen
import com.espi.brainbattles2.ui.screens.HomeScreenContent
import com.espi.brainbattles2.ui.screens.SettingsScreen
import com.espi.brainbattles2.ui.theme.BrainBattles2Theme
import com.espi.brainbattles2.viewmodel.SettingsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BrainBattles2Theme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(
    settingsViewModel: SettingsViewModel = viewModel()
) {
    val navController = rememberNavController()
    val backgroundColor by settingsViewModel.backgroundColor.observeAsState(0xFF6200EE.toInt())

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(backgroundColor))
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.fillMaxSize()
        ) {
            composable(Screen.Home.route) {
                HomeScreenContent(
                    onStartGame = { navController.navigate(Screen.Game.route) },
                    onOpenSettings = { navController.navigate(Screen.Settings.route) }
                )
            }

            composable(Screen.Game.route) {
                GameScreen(
                    onGameOver = { navController.navigate(Screen.Home.route) }
                )
            }

            composable(Screen.Settings.route) {
                SettingsScreen()
            }
        }
    }
}
package com.example.marvel.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.marvel.domain.model.Hero
import com.example.marvel.presentation.Screens
import com.example.marvel.presentation.screens.main.MainScreen
import com.example.marvel.presentation.screens.main.MainViewModel
import com.example.marvel.presentation.screens.network_error.ConnectionErrorScreen
import com.example.marvel.presentation.screens.network_error.ConnectionErrorViewModel
import com.example.marvel.presentation.screens.start.StartScreen
import com.example.marvel.presentation.screens.start.StartViewModel
import com.example.marvel.presentation.utils.ConnectionStatus
import com.example.marvel.presentation.utils.getCurrentConnectivityStatus


@Composable
fun NavGraph(navHostController: NavHostController, selectedHero: MutableState<Hero>) {
    val context = LocalContext.current
    NavHost(
        navController = navHostController,
        startDestination = Screens.START_SCREEN
    ) {
        composable(route = Screens.START_SCREEN) {
            val isConnected =
                checkInternet(connection = getCurrentConnectivityStatus(context = context))
            val viewModel = hiltViewModel<StartViewModel>()

            StartScreen(
                viewModel = viewModel,
                onHeroClick = { hero ->
                    selectedHero.value = hero
                    navHostController.navigate(route = Screens.FULL_SCREEN)
                }
            )
        }
        composable(route = Screens.FULL_SCREEN) {
            val isConnected =
                checkInternet(connection = getCurrentConnectivityStatus(context = context))
            val viewModel = hiltViewModel<MainViewModel>()

            MainScreen(
                item = selectedHero.value,
                onBackClick = {
                    navHostController.navigateUp()
                }
            )
        }

        composable(
            route = "${Screens.NO_INTERNET_SCREEN}/{screen}",
            arguments = listOf(
                navArgument("screen") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val screen = backStackEntry.arguments?.getString("screen") ?: ""
            val connectionErrorViewModel = ConnectionErrorViewModel()
            ConnectionErrorScreen(
                onNetworkIntent = connectionErrorViewModel::onIntent,
                networkErrorEffect = connectionErrorViewModel.connectionErrorEffect,
                navHostController = navHostController,
                screen = screen
            )
        }
    }
}

private fun checkInternet(connection: ConnectionStatus): Boolean {
    val isConnected = connection === ConnectionStatus.Available
    return isConnected
}

package com.example.marvel.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.marvel.data.dao.provideDatabase
import com.example.marvel.data.network.marvelEngine
import com.example.marvel.data.network.repository.HeroRepositoryImpl
import com.example.marvel.data.network.storage.HeroStorage
import com.example.marvel.data.network.useCase.GetHeroByIdUseCase
import com.example.marvel.data.network.useCase.GetHeroesUseCase
import com.example.marvel.domain.model.Hero
import com.example.marvel.presentation.Screens
import com.example.marvel.presentation.screens.main.MainScreen
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
            val viewModel = StartViewModel(
                heroStorage = HeroStorage(
                    getHeroesUseCase = GetHeroesUseCase(
                        dao = provideDatabase(context = context).getSuperheroesDao(),
                        context = context,
                        heroRepository = HeroRepositoryImpl(
                            marvelApi = marvelEngine()
                        )
                    ),
                    getHeroByIdUseCase = GetHeroByIdUseCase(
                        heroRepository = HeroRepositoryImpl(
                            marvelApi = marvelEngine()
                        )
                    )
                )
            )

            StartScreen(
                viewModel = viewModel,
                onHeroClick = { hero ->
                    selectedHero.value = hero
                    navHostController.navigate(route = Screens.FULL_SCREEN)
                }
            )
            if (isConnected) {

                val viewModel = StartViewModel(
                    heroStorage = HeroStorage(
                        getHeroesUseCase = GetHeroesUseCase(
                            heroRepository = HeroRepositoryImpl(
                                marvelApi = marvelEngine()
                            )
                        ),
                        getHeroByIdUseCase = GetHeroByIdUseCase(
                            heroRepository = HeroRepositoryImpl(
                                marvelApi = marvelEngine()
                            )
                        )
                    )
                )

                StartScreen(
                    viewModel = viewModel,
                    onHeroClick = { hero ->
                        selectedHero.value = hero
                        navHostController.navigate(route = Screens.FULL_SCREEN)
                    }
                )
            } else {
                navHostController.previousBackStackEntry?.savedStateHandle?.set(
                    "screen",
                    Screens.START_SCREEN
                )
                navHostController.navigate(route = "${Screens.NO_INTERNET_SCREEN}/${Screens.START_SCREEN}")
            }
        }
        composable(route = Screens.FULL_SCREEN) {
            val isConnected =
                checkInternet(connection = getCurrentConnectivityStatus(context = context))
            MainScreen(
                item = selectedHero.value,
                onBackClick = {
                    navHostController.navigateUp()
                }
            )
            if (isConnected) {
                MainScreen(
                    item = selectedHero.value,
                    onBackClick = {
                        navHostController.navigateUp()
                    }
                )
            } else {
                navHostController.previousBackStackEntry?.savedStateHandle?.set(
                    "screen",
                    Screens.FULL_SCREEN
                )
                navHostController.navigate(route = "${Screens.NO_INTERNET_SCREEN}/${Screens.FULL_SCREEN}")
            }
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

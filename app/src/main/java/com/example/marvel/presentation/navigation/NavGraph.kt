package com.example.marvel.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.marvel.data.network.marvelEngine
import com.example.marvel.data.network.repository.HeroRepositoryImpl
import com.example.marvel.data.network.storage.HeroStorage
import com.example.marvel.data.network.useCase.GetHeroByIdUseCase
import com.example.marvel.data.network.useCase.GetHeroesUseCase
import com.example.marvel.domain.model.Hero
import com.example.marvel.presentation.Screens
import com.example.marvel.presentation.screens.main.MainScreen
import com.example.marvel.presentation.screens.start.StartScreen
import com.example.marvel.presentation.screens.start.StartViewModel

@Composable
fun NavGraph(navHostController: NavHostController, selectedHero: MutableState<Hero>) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.START_SCREEN
    ) {
        composable(route = Screens.START_SCREEN) {
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
        }
        composable(route = Screens.FULL_SCREEN) {
            MainScreen(
                item = selectedHero.value,
                onBackClick = {
                    navHostController.navigateUp()
                }
            )
        }
    }
}

package com.example.marvel.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.marvel.model.Hero
import com.example.marvel.presentation.Screens
import com.example.marvel.presentation.screens.full.HeroPage
import com.example.marvel.presentation.screens.start.StartScreen

@Composable
fun NavGraph(navHostController: NavHostController, selectedHero: MutableState<Hero>) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.START_SCREEN
    ) {
        composable(route = Screens.START_SCREEN) {
            StartScreen(onHeroClick = { hero ->
                selectedHero.value = hero
                navHostController.navigate(route = Screens.FULL_SCREEN)
            })
        }
        composable(route = Screens.FULL_SCREEN) {
            HeroPage(item = selectedHero.value, onBackClick = {
                navHostController.popBackStack()
            })
        }
    }
}

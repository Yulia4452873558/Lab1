package com.example.marvel.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.marvel.mock.getMockHeroes

@Composable
fun AppNavigation() {
    val selectedHero = remember {
        mutableStateOf(getMockHeroes()[0])
    }
    val navController = rememberNavController()
    NavGraph(navController, selectedHero = selectedHero)
}

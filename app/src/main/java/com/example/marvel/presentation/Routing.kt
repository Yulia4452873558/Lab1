package com.example.marvel.presentation

sealed class Screens(val route: String) {
    data object Start : Screens("hero_screen")
    data object FullCard : Screens("card_screen")
}

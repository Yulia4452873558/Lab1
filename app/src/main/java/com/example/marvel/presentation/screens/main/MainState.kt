package com.example.marvel.presentation.screens.main

import com.example.marvel.domain.model.Hero

sealed class MainState {
    data class Success(val hero: Hero) : MainState()
    data object Loading : MainState()
    data object Error : MainState()
}

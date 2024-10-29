package com.example.marvel.presentation.screens.start.store

import com.example.marvel.domain.model.Hero

data class StartState(
    val heroes: List<Hero>? = emptyList()
)

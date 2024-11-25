package com.example.marvel.mock

import com.example.marvel.App
import com.example.marvel.data.dao.database
import com.example.marvel.data.network.marvelEngine
import com.example.marvel.data.network.repository.HeroRepositoryImpl
import com.example.marvel.data.network.storage.HeroStorage
import com.example.marvel.data.network.useCase.GetHeroByIdUseCase
import com.example.marvel.data.network.useCase.GetHeroesUseCase
import com.example.marvel.presentation.screens.start.StartViewModel

val startScreenViewModel = StartViewModel(
    heroStorage = HeroStorage(
        getHeroesUseCase = GetHeroesUseCase(
            dao = database(context = App.INSTANCE).getSuperheroesDao(),
            context = App.INSTANCE,
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

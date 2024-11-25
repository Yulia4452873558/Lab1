package com.example.marvel.data.network.storage

import com.example.marvel.data.network.useCase.GetHeroByIdUseCase
import com.example.marvel.data.network.useCase.GetHeroesUseCase

class HeroStorage(
    private val getHeroByIdUseCase: GetHeroByIdUseCase,
    private val getHeroesUseCase: GetHeroesUseCase
) {
    suspend fun getHeroById(id: Int) = getHeroByIdUseCase.execute(id = id)
    suspend fun getAllHeroes() = getHeroesUseCase.execute()
}

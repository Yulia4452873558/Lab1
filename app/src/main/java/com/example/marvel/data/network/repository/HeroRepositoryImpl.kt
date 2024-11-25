package com.example.marvel.data.network.repository

import com.example.marvel.data.network.api.MarvelApi
import com.example.marvel.data.network.dto.HeroResponse

class HeroRepositoryImpl(
    private val marvelApi: MarvelApi
) : HeroRepository {

    override suspend fun getHeroById(id: String): HeroResponse {
        val response = marvelApi.getSuperhero(
            heroId = id
        )
        return response
    }

    override suspend fun getAllHeroes(): HeroResponse {
        val response = marvelApi.getSuperheroes()
        return response
    }
}

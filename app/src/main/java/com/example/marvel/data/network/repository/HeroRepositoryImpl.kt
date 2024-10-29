package com.example.marvel.data.network.repository

import com.example.marvel.data.network.api.MarvelApi
import com.example.marvel.data.network.characters.CharacterRoot

class HeroRepositoryImpl constructor(
    private val marvelApi: MarvelApi
) : HeroRepository {

    override suspend fun getHeroById(id: String): CharacterRoot {
        val response = marvelApi.getSuperhero(
            heroId = id
        )
        return response
    }

    override suspend fun getAllHeroes(): CharacterRoot {
        val response = marvelApi.getSuperheroes()
        return response
    }
}

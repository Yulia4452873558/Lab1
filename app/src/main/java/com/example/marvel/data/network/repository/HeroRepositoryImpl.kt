package com.example.marvel.data.network.repository

import android.util.Log
import com.example.marvel.data.network.api.HeroResponse
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
        Log.d("tag",response.toString())
        return response
    }
}

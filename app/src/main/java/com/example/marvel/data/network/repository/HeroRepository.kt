package com.example.marvel.data.network.repository

import com.example.marvel.data.network.dto.HeroResponse

interface HeroRepository {
    suspend fun getHeroById(id: String): HeroResponse

    suspend fun getAllHeroes(): HeroResponse
}

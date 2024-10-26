package com.example.marvel.data.network.repository

import com.example.marvel.data.network.api.HeroResponse
import com.example.marvel.data.network.characters.CharacterRoot
import com.example.marvel.domain.model.Hero

interface HeroRepository {
    suspend fun getHeroById(id: String): CharacterRoot

    suspend fun getAllHeroes(): CharacterRoot
}

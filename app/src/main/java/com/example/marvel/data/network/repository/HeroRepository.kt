package com.example.marvel.data.network.repository

import com.example.marvel.data.network.characters.CharacterRoot

interface HeroRepository {
    suspend fun getHeroById(id: String): CharacterRoot

    suspend fun getAllHeroes(): CharacterRoot
}

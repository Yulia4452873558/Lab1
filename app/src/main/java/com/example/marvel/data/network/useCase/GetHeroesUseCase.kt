package com.example.marvel.data.network.useCase

import com.example.marvel.data.network.repository.HeroRepository
import com.example.marvel.domain.model.Hero

class GetHeroesUseCase(
    private val heroRepository: HeroRepository
) {
    suspend fun execute(): List<Hero>? {
        val heroResponse = heroRepository.getAllHeroes().data?.results
        return heroResponse?.map {
            Hero(
                heroNameResId = it.name ?: "",
                heroDescriptionResId = it.description ?: "",
                heroImageResId = it.resourceURI,
                heroColor = Hero.generateColor()
            )                                                             // map превращает в нужный объект
        }
    }
}
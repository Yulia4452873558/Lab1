package com.example.marvel.data.network.useCase

import com.example.marvel.data.network.repository.HeroRepository
import com.example.marvel.domain.model.Hero

class GetHeroesUseCase(
    private val heroRepository: HeroRepository
) {
    suspend fun execute(): List<Hero>? {
        val heroResponse = heroRepository.getAllHeroes().data?.results
        return heroResponse?.map {

            val imagePath = if (it.thumbnail?.path?.startsWith("http://")!!) {
                it.thumbnail?.path?.replace("http", "https")
            } else {
                it.thumbnail?.path
            } + "." + it.thumbnail?.extension

            Hero(
                heroNameResId = it.name ?: "",
                heroDescriptionResId = it.description ?: "Hello",
                heroImageResId = imagePath,
                heroColor = Hero.generateColor()
            )
        }
    }
}

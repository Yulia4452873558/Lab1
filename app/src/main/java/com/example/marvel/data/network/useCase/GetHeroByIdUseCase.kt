package com.example.marvel.data.network.useCase

import com.example.marvel.data.network.repository.HeroRepository
import com.example.marvel.domain.model.Hero

class GetHeroByIdUseCase (
    private val heroRepository: HeroRepository
) {
    suspend fun execute(id: Int): Hero {
        val heroResponse = heroRepository.getHeroById(id.toString()).data?.results?.get(0)
        return Hero(
            heroNameResId = heroResponse?.name ?: "",
            heroDescriptionResId = heroResponse?.description ?: "",
            heroImageResId = heroResponse?.resourceURI,
            heroColor = Hero.generateColor()
        )
    }
}


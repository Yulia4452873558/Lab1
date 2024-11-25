package com.example.marvel.data.network.useCase

import android.content.Context
import com.example.marvel.data.dao.SuperheroDao
import com.example.marvel.data.dao.SuperheroEntity.Companion.toHero
import com.example.marvel.data.network.dto.Results.Companion.toSuperheroEntity
import com.example.marvel.data.network.repository.HeroRepository
import com.example.marvel.domain.model.Hero
import com.example.marvel.presentation.utils.ConnectionStatus
import com.example.marvel.presentation.utils.getCurrentConnectivityStatus

class GetHeroesUseCase(
    private val heroRepository: HeroRepository,
    private val dao: SuperheroDao,
    private val context: Context
) {
    suspend fun execute(): List<Hero> {
        if (getCurrentConnectivityStatus(context = context) === ConnectionStatus.Available) {
            val heroResponse = heroRepository.getAllHeroes().data?.results

            dao.deleteAllData()

            heroResponse?.map {
                it.toSuperheroEntity()
            }?.toTypedArray()?.let {
                dao.upsertData(superheroEntity = it)
            }
        }
        return dao.getAllHeroes().map {
            it.toHero()
        }
    }
}

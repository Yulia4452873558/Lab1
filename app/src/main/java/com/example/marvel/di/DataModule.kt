package com.example.marvel.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.marvel.App
import com.example.marvel.data.constant.ApiConstants
import com.example.marvel.data.dao.AppDatabase
import com.example.marvel.data.dao.SuperheroDao
import com.example.marvel.data.dao.database
import com.example.marvel.data.network.api.MarvelApi
import com.example.marvel.data.network.marvelEngine
import com.example.marvel.data.network.repository.HeroRepository
import com.example.marvel.data.network.repository.HeroRepositoryImpl
import com.example.marvel.data.network.storage.HeroStorage
import com.example.marvel.data.network.useCase.GetHeroByIdUseCase
import com.example.marvel.data.network.useCase.GetHeroesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun provideMarvelEngine(): MarvelApi {
        return marvelEngine()
    }

    @Provides
    @Singleton
    fun provideHeroRepository(marvelApi: MarvelApi): HeroRepository {
        return HeroRepositoryImpl(marvelApi)
    }

    @Provides
    @Singleton
    fun provideGetAllHeroesUseCase(heroRepository: HeroRepository, dao: SuperheroDao, context: Context): GetHeroesUseCase {
        return GetHeroesUseCase(
            heroRepository = heroRepository,
            dao = dao,
            context = context
        )
    }

    @Provides
    @Singleton
    fun provideGetHeroByIdUseCase(heroRepository: HeroRepository): GetHeroByIdUseCase {
        return GetHeroByIdUseCase(
            heroRepository = heroRepository
        )
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return database(context = context)
    }

    @Singleton
    @Provides
    fun provideSuperheroDao(@ApplicationContext context: Context): SuperheroDao = provideDatabase(context = context).getSuperheroesDao()

    @Singleton
    @Provides
    fun provideHeroStorage(@ApplicationContext context: Context): HeroStorage {
        return HeroStorage(
            getHeroesUseCase = provideGetAllHeroesUseCase(
                heroRepository = provideHeroRepository(marvelApi = provideMarvelEngine()),
                dao = provideSuperheroDao(context = context),
                context = context
            ),
            getHeroByIdUseCase = GetHeroByIdUseCase(
                heroRepository = HeroRepositoryImpl(marvelApi = provideMarvelEngine())
            )
        )
    }
}

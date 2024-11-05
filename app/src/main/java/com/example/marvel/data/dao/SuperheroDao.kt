package com.example.marvel.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface SuperheroDao {

    @Query("DELETE  FROM SuperheroEntity ")
    suspend fun deleteAllData()

    @Query("SELECT * FROM SuperheroEntity ")
    suspend fun getAllHeroes(): List<SuperheroEntity>

    @Upsert(entity = SuperheroEntity::class)
    suspend fun upsertData(vararg superheroEntity: SuperheroEntity)
}




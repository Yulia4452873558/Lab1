package com.example.marvel.data.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SuperheroEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getSuperheroesDao(): SuperheroDao
}

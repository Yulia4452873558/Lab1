package com.example.marvel.data.dao

import android.content.Context
import androidx.room.Room


fun provideDatabase(context: Context): AppDatabase {
    return Room
        .databaseBuilder(context, AppDatabase::class.java, "character")
        .build()
}

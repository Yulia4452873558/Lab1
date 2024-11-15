package com.example.marvel.data.dao

import android.content.Context
import androidx.room.Room


fun database(context: Context): AppDatabase {
    return Room
        .databaseBuilder(context, AppDatabase::class.java, "character")
        .build()
}

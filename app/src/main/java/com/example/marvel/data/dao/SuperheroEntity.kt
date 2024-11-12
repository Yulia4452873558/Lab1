package com.example.marvel.data.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.marvel.domain.model.Hero

@Entity
data class SuperheroEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Int,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("description") val description: String,
    @ColumnInfo("image_url") val imageUrl: String,
) {
    companion object {
        fun SuperheroEntity.toHero(): Hero {
            return Hero(
                heroNameResId = this.name,
                heroDescriptionResId = this.description,
                heroImageResId = this.imageUrl,
                heroColor = Hero.generateColor()
            )
        }
    }
}

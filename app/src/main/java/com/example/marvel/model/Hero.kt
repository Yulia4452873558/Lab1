package com.example.marvel.model

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

data class Hero (
    val heroNameResId: Int,
    val heroDescriptionResId: Int,
    val heroImageResId: Int,
    val heroColor: Color = generateColor()
) {
    companion object {
        fun generateColor() : Color {
            return Color(Random.nextLong(from = 0xFF000000, until = 0xFFFFFFFF))
        }
    }
}

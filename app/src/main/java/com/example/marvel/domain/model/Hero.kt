package com.example.marvel.domain.model

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

data class Hero (
    val heroNameResId: String,
    val heroDescriptionResId: String,
    val heroImageResId: String?,
    val heroColor: Color
) {
    companion object {
        fun generateColor() : Color {
            return Color(Random.nextLong(from = 0xFF000000, until = 0XFFFFFFFF))
        }
    }
}

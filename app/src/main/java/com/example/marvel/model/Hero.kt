package com.example.marvel.model

import androidx.compose.ui.graphics.Color

data class Hero (
    val heroNameResId: Int,
    val heroDescriptionResId: Int,
    val heroImageResId: String?,
    val heroColor: Color
)

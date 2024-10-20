package com.example.marvel.mock

import androidx.compose.ui.graphics.Color
import com.example.marvel.R
import com.example.marvel.model.Hero
import kotlin.random.Random

fun getMockHeroes(): List<Hero> {
    val list: List<Hero> = listOf(
        Hero(
            heroColor = Color(Random.nextLong(from = 0xFF000000, until = 0xFFFFFFFF)),
            heroImageResId = R.drawable.deadpoll_image,
            heroDescriptionResId = R.string.deadpool_quote,
            heroNameResId = R.string.deadpool_name
        ),
        Hero(
            heroColor = Color(Random.nextLong(from = 0xFF000000, until = 0xFFFFFFFF)),
            heroImageResId = R.drawable.irom_man,
            heroDescriptionResId = R.string.icon_man_quote,
            heroNameResId = R.string.icon_man_name
        ),
        Hero(
            heroColor = Color(Random.nextLong(from = 0xFF000000, until = 0xFFFFFFFF)),
            heroImageResId = R.drawable.spider_man,
            heroDescriptionResId = R.string.spider_man_quote,
            heroNameResId = R.string.spider_man_name
        )
    )
    return list
}

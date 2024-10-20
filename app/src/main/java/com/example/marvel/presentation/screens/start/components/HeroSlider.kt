package com.example.marvel.presentation.screens.start.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.marvel.model.Hero
import com.example.marvel.presentation.theme.MarvelTheme

@Composable
fun HeroSlider(
    modifier: Modifier = Modifier,
    hero: Hero
) {
    Box(modifier = modifier) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = hero.heroImageResId,
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }

}

@Preview
@Composable
private fun HeroSliderPreview() {
    MarvelTheme {

    }
}
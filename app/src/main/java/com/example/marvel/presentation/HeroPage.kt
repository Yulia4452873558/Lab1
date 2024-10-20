package com.example.marvel.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.marvel.model.Hero
import com.example.marvel.presentation.theme.MarvelTheme


@Composable
fun HeroPage(
    heroes: MutableList<Hero>,
    onHeroClick: (Hero) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Spacer(modifier = Modifier.height(27.dp))
            Header()
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun HeaderPreview() {
    MarvelTheme(dynamicColor = false) {
        HeroPage(heroes = remember { mutableListOf() }, {})
    }
}

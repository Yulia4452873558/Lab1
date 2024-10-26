package com.example.marvel.presentation.screens.start.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.marvel.R
import com.example.marvel.mock.getMockHeroes
import com.example.marvel.domain.model.Hero
import com.example.marvel.presentation.theme.MarvelTheme
import com.example.marvel.presentation.theme.Sizes
import com.example.marvel.presentation.theme.Spaces

@Composable
fun HeroCard(item: Hero, onHeroClick: (Hero) -> Unit = {}) {
    Button(
        modifier = Modifier
            .width(width = Sizes.HeroCard.width)
            .height(height = Sizes.HeroCard.height),
        shape = MaterialTheme.shapes.medium,
        contentPadding = PaddingValues(all = Sizes.HeroCard.allPadding),
        onClick = {
            onHeroClick(item)
        }
    ) {
        Box(modifier = Modifier.wrapContentSize()) {
            AsyncImage(
                model = item.heroImageResId,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
                    .background(MaterialTheme.colorScheme.onBackground),
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(id = R.string.hero_image)
            )
            Text(
                modifier = Modifier
                    .wrapContentSize()
                    .align(alignment = Alignment.BottomStart)
                    .padding(all = Spaces.heroNamePadding),
                text = item.heroNameResId,
                style = MaterialTheme.typography.titleMedium.copy(color = Color.White)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HeroCardPreview() {
    MarvelTheme {
        HeroCard(item = getMockHeroes()[0], {})
    }
}

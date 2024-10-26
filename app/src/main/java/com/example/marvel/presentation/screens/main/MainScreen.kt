package com.example.marvel.presentation.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.marvel.R
import com.example.marvel.mock.getMockHeroes
import com.example.marvel.domain.model.Hero
import com.example.marvel.presentation.screens.start.StartViewModel
import com.example.marvel.presentation.theme.MarvelTheme
import com.example.marvel.presentation.theme.Spaces

@Composable
fun MainScreen(item: Hero, onBackClick: () -> Unit) {
    val viewModel = viewModel<StartViewModel>()

    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = item.heroImageResId,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(id = R.string.hero_image)
        )
        IconButton(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(PaddingValues(top = Spaces.heroNamePadding)),
            onClick = onBackClick,
            colors = IconButtonDefaults.iconButtonColors(
                contentColor = MaterialTheme.colorScheme.onBackground
            )
        ) {
            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = stringResource(id = R.string.back_button)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = Spaces.allPaddingScreen)
                .align(Alignment.BottomStart),
            verticalArrangement = Arrangement.spacedBy(
                space = Spaces.heroPageSpace
            ),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = item.heroNameResId,
                style = MaterialTheme.typography.titleMedium.copy(
                    color = MaterialTheme.colorScheme.onBackground
                ),
                textAlign = TextAlign.Start
            )
            Text(
                text = item.heroDescriptionResId,
                style = MaterialTheme.typography.labelLarge.copy(
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Start
                )
            )
            Spacer(modifier = Modifier.height(Spaces.heroPageSpacer))
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun HeroPage_() {
    MarvelTheme() {
        Surface {
            MainScreen(item = getMockHeroes()[0], {})
        }
    }
}
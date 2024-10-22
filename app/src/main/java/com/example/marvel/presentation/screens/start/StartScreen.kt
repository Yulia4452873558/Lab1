package com.example.marvel.presentation.screens.start

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.marvel.R
import com.example.marvel.mock.getMockHeroes
import com.example.marvel.model.Hero
import com.example.marvel.presentation.screens.start.components.Header
import com.example.marvel.presentation.screens.start.components.HeroSlider
import com.example.marvel.presentation.theme.MarvelTheme

@Composable
fun StartScreen(onHeroClick: (Hero) -> Unit = {}) {
    val heroBackColor = remember {
        mutableStateOf(getMockHeroes()[0].heroColor)
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Icon(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .align(Alignment.BottomEnd),
            tint = heroBackColor.value,
            painter = painterResource(id = R.drawable.hero_back),
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(27.dp))
            Header()
            HeroSlider(
                list = getMockHeroes(),
                onHeroClick = onHeroClick,
                onScroll = { color ->
                    heroBackColor.value = color
                }
            )
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun StartScreenPreview() {
    MarvelTheme {
        Surface {
            StartScreen()
        }
    }
}

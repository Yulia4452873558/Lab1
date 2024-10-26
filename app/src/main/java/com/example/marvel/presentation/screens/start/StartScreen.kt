package com.example.marvel.presentation.screens.start

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.marvel.R
import com.example.marvel.data.network.marvelEngine
import com.example.marvel.data.network.repository.HeroRepositoryImpl
import com.example.marvel.data.network.storage.HeroStorage
import com.example.marvel.data.network.useCase.GetHeroByIdUseCase
import com.example.marvel.data.network.useCase.GetHeroesUseCase
import com.example.marvel.mock.getMockHeroes
import com.example.marvel.domain.model.Hero
import com.example.marvel.presentation.screens.start.components.Header
import com.example.marvel.presentation.screens.start.components.HeroSlider
import com.example.marvel.presentation.screens.start.store.StartState
import com.example.marvel.presentation.theme.MarvelTheme

@Composable
fun StartScreen(
    onHeroClick: (Hero) -> Unit = {},
    navController: NavController
) {

    val viewModel: StartViewModel = StartViewModel(
        heroStorage = HeroStorage(
            getHeroesUseCase = GetHeroesUseCase(heroRepository = HeroRepositoryImpl(marvelApi = marvelEngine())),
            getHeroByIdUseCase = GetHeroByIdUseCase(heroRepository = HeroRepositoryImpl(marvelApi = marvelEngine()))
        )
    )
    val state by viewModel.stateFlow.collectAsState()

    val heroBackColor = remember {
        mutableStateOf(Color.White)
    }
    LaunchedEffect(Unit) {
        viewModel.getAllHeroes()
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
            if (state.heroes?.isEmpty()!!) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else {
                HeroSlider(
                    list = state.heroes!!,
                    onHeroClick = onHeroClick,
                    onScroll = { color ->
                        heroBackColor.value = color
                    }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun StartScreenPreview() {
    MarvelTheme {
        Surface {
            StartScreen(
                navController = rememberNavController()
            )
        }
    }
}

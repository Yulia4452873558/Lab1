package com.example.marvel.presentation.screens.start.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import com.example.marvel.model.Hero


@Composable
fun HeroBack(heroes: MutableList<Hero>) {
    val heroBackColor = remember {
        mutableStateOf(if (heroes.isNotEmpty()) heroes[0].heroColor else Hero.generateColor())
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            drawPath(
                color = heroBackColor.value,
                path = Path().apply {
                    moveTo(size.width, size.height * 0.4f)
                    lineTo(0f, size.height)
                    lineTo(size.width, size.height)
                    close()
                }
            )
        }
    }
}

@Preview
@Composable
private fun HeroBackPreview() {
    HeroBack(heroes = remember { mutableListOf() })
}

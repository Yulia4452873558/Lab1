package com.example.marvel.presentation.screens.start.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import com.example.marvel.mock.getMockHeroes
import com.example.marvel.domain.model.Hero
import com.example.marvel.presentation.theme.MarvelTheme
import com.example.marvel.presentation.theme.Spaces


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HeroSlider(
    list: List<Hero>,
    onScroll: (Color) -> Unit = {},
    onHeroClick: (Hero) -> Unit = {}
) {
    val state = rememberLazyListState()
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(
                available: Offset,
                source: NestedScrollSource
            ): Offset {
                val firstVisibleItemIndex =
                    state.layoutInfo.visibleItemsInfo.firstOrNull()?.index ?: -1
                val lastVisibleItemIndex =
                    state.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: -1
                if (firstVisibleItemIndex != -1) {
                    val color = if (firstVisibleItemIndex == 0) {
                        if (lastVisibleItemIndex == 1) {
                            list[firstVisibleItemIndex].heroColor
                        } else {
                            list[1].heroColor
                        }
                    } else {
                        list[firstVisibleItemIndex + 1].heroColor
                    }
                    onScroll(color)
                }
                return super.onPreScroll(available, source)
            }
        }
    }
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .nestedScroll(connection = nestedScrollConnection),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        state = state,
        flingBehavior = rememberSnapFlingBehavior(lazyListState = state)
    ) {
        itemsIndexed(list) { _, item ->
            Spacer(modifier = Modifier.width(width = Spaces.heroSliderSpace))
            HeroCard(onHeroClick = onHeroClick, item = item)
            Spacer(modifier = Modifier.width(width = Spaces.heroSliderSpace))
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun HeroSliderPreview() {
    MarvelTheme {
        Surface {
            HeroSlider(list = getMockHeroes())
        }
    }
}

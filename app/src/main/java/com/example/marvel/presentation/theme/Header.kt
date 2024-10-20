package com.example.marvel.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.marvel.R
import com.example.marvel.presentation.theme.MarvelTheme
import com.example.marvel.presentation.theme.Size
import com.example.marvel.presentation.theme.Space

@Composable
fun Header() {
    Column(
        verticalArrangement = Arrangement.spacedBy(
            space = Space.headerPadding,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Image(
            modifier = Modifier
                .width(width = Size.MarvelLogo.width)
                .height(height = Size.MarvelLogo.height),
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = stringResource(R.string.marvel_logo)
        )
        Text(
            text = stringResource(R.string.header_str),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}



@Preview(showBackground = true)
@Composable
private fun HeaderPreview() {
    MarvelTheme(dynamicColor = false) {
        Header()
    }
}

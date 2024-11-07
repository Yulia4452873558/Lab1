package com.example.marvel.presentation.screens.network_error.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.marvel.R
import com.example.marvel.presentation.screens.network_error.store.ConnectionErrorIntent


@Composable
fun ErrorItem(
    onNetworkErrorIntent: (ConnectionErrorIntent) -> Unit,
    screen: String,
) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(vertical = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .padding(vertical = 20.dp)
                .size(128.dp),
            painter = painterResource(R.drawable.connection_error),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = stringResource(R.string.connection_error),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold

                )
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = stringResource(R.string.error_sub),
                style = MaterialTheme.typography.bodyLarge.copy(MaterialTheme.colorScheme.onBackground)
            )

            Spacer(modifier = Modifier.weight(1.0f))

            Row(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
            ) {
                SecondaryButton(
                    text = stringResource(R.string.click_repeat),
                    enabled = true,
                    onClick = {
                        onNetworkErrorIntent(ConnectionErrorIntent.ClickRepeat(value = screen))
                    }
                )
            }
        }
    }
}

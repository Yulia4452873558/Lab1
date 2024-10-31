package com.example.marvel.presentation.screens.network_error

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.marvel.presentation.screens.network_error.components.ErrorItem
import com.example.marvel.presentation.screens.network_error.store.ConnectionErrorEffect
import com.example.marvel.presentation.screens.network_error.store.ConnectionErrorIntent
import com.example.marvel.presentation.theme.MarvelTheme
import com.example.marvel.presentation.utils.ConnectionStatus
import com.example.marvel.presentation.utils.getCurrentConnectivityStatus
import kotlinx.coroutines.flow.MutableSharedFlow


@Composable
fun ConnectionErrorScreen(
    onNetworkIntent: (ConnectionErrorIntent) -> Unit,
    networkErrorEffect: MutableSharedFlow<ConnectionErrorEffect>,
    navHostController: NavHostController,
    screen: String
) {
    val context = LocalContext.current
    Scaffold {
        onNetworkIntent(ConnectionErrorIntent.ClickRepeat(value = screen))

        LaunchedEffect(key1 = Unit) {
            networkErrorEffect.collect { effect ->
                when (effect) {
                    is ConnectionErrorEffect.ClickRepeat -> {
                        val isConnected =
                            getCurrentConnectivityStatus(context = context) === ConnectionStatus.Available
                        if (isConnected) {
                            navHostController.navigate(route = screen)
                        }
                    }
                }
            }
        }

        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 60.dp)
                .padding(it),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ErrorItem(
                onNetworkErrorIntent = {
                    onNetworkIntent(ConnectionErrorIntent.ClickRepeat(value = screen))
                },
                screen = screen
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun NetworkErrorScreen() {
    MarvelTheme(darkTheme = false, dynamicColor = false) {
        val connectionErrorViewModel = ConnectionErrorViewModel()
        ConnectionErrorScreen(
            onNetworkIntent = connectionErrorViewModel::onIntent,
            networkErrorEffect = connectionErrorViewModel.connectionErrorEffect,
            navHostController = rememberNavController(),
            screen = ""
        )
    }
}

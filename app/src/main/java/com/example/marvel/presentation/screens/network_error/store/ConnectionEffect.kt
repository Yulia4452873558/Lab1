package com.example.marvel.presentation.screens.network_error.store

sealed class ConnectionErrorEffect {
    data class ClickRepeat(val value: String) : ConnectionErrorEffect()
}

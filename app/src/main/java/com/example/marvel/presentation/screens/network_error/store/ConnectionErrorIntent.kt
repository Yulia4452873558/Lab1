package com.example.marvel.presentation.screens.network_error.store

sealed class ConnectionErrorIntent {
    data class ClickRepeat(val value: String) : ConnectionErrorIntent()
}

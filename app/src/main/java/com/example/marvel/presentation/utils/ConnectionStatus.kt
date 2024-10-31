package com.example.marvel.presentation.utils

sealed class ConnectionStatus {
    object Available: ConnectionStatus()
    object Unavailable: ConnectionStatus()
}

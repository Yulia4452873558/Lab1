package com.example.marvel.presentation.screens.network_error

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel.presentation.screens.network_error.store.ConnectionErrorEffect
import com.example.marvel.presentation.screens.network_error.store.ConnectionErrorEffect.ClickRepeat
import com.example.marvel.presentation.screens.network_error.store.ConnectionErrorIntent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class ConnectionErrorViewModel : ViewModel() {
    val connectionErrorEffect = MutableSharedFlow<ConnectionErrorEffect>()

    fun onIntent(intent: ConnectionErrorIntent) {
        when (intent) {
            is ConnectionErrorIntent.ClickRepeat -> {
                viewModelScope.launch {
                    connectionErrorEffect.emit(ClickRepeat(value = intent.value))
                }
            }
        }
    }
}

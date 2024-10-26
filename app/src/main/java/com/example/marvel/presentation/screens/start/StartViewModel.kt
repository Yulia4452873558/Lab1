package com.example.marvel.presentation.screens.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.marvel.data.network.repository.HeroRepositoryImpl
import com.example.marvel.data.network.repository.HeroRepository
import com.example.marvel.data.network.storage.HeroStorage
import com.example.marvel.presentation.screens.start.store.StartState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class StartViewModel(
    private val heroStorage: HeroStorage
) : ViewModel() {
    private val heroStateFlow = MutableStateFlow(StartState(emptyList()))
    val stateFlow: StateFlow<StartState> = heroStateFlow

    fun getAllHeroes() {
        viewModelScope.launch {
            val allHeroes = heroStorage.getAllHeroes()
            heroStateFlow.update {
                it.copy(heroes = allHeroes)
            }
        }
    }
}

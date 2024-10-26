package com.example.marvel.presentation.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel.data.network.repository.HeroRepositoryImpl
import com.example.marvel.data.network.repository.HeroRepository
import com.example.marvel.data.network.storage.HeroStorage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val heroStorage: HeroStorage
) : ViewModel(){
    private val mainStateFlow: MutableStateFlow<MainState> = MutableStateFlow(MainState.Loading)
    val stateFlow: StateFlow<MainState> = mainStateFlow

    fun getHeroById(id: Int) {
        viewModelScope.launch {
            val getHero = heroStorage.getHeroById(id)
            mainStateFlow.update {
                MainState.Success(hero = getHero)
            }
        }
    }
}

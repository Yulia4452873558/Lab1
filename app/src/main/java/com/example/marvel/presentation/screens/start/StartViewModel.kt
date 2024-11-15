package com.example.marvel.presentation.screens.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel.data.network.storage.HeroStorage
import com.example.marvel.presentation.screens.start.store.StartState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
    private val heroStorage: HeroStorage
) : ViewModel() {
    val heroStateFlow = MutableStateFlow(StartState())
    private val supervisorIoCoroutineContext = SupervisorJob() + Dispatchers.IO

    init {
        getAllHeroes()
    }

    private fun getAllHeroes() {
        viewModelScope.launch(supervisorIoCoroutineContext) {
            val allHeroes = heroStorage.getAllHeroes()
            withContext(viewModelScope.coroutineContext) {
                heroStateFlow.update {
                    it.copy(heroes = allHeroes)
                }
            }
        }
    }
}

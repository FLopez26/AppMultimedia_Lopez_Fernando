package com.example.appmultimedia_lopez_fernando.presentation.viewmodel.games

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appmultimedia_lopez_fernando.domain.model.Game
import com.example.appmultimedia_lopez_fernando.domain.usecase.games.GamesUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class GamesScreenViewModel(
    private val gamesScreenUseCase: GamesUseCase
) : ViewModel() {
    private val _games = gamesScreenUseCase()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val games: StateFlow<List<Game>> = _games
}
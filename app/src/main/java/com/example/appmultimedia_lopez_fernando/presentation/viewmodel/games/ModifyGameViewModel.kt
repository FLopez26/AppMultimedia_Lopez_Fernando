package com.example.appmultimedia_lopez_fernando.presentation.viewmodel.games

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appmultimedia_lopez_fernando.domain.model.Game
import com.example.appmultimedia_lopez_fernando.domain.usecase.games.GetGameUseCase
import com.example.appmultimedia_lopez_fernando.domain.usecase.games.ModifyGameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class ModifyGameViewModel(
    val modifyGameUseCase: ModifyGameUseCase,
    val getGameUseCase: GetGameUseCase
) : ViewModel() {
    private val _game = MutableStateFlow(
        Game("", "","","",0,0,0,"")
    )
    val game: StateFlow<Game> = _game

    fun setId(id: String?) {
        viewModelScope.launch {
            _game.value = getGameUseCase(id)?: Game("", "","","",0,0,0,"")
        }
    }

    fun setName(name: String) {
        _game.value = _game.value.copy(
            name = name
        )
    }
    fun setLocation(location: String) {
        _game.value = _game.value.copy(
            location = location
        )
    }
    fun setType(type: String) {
        _game.value = _game.value.copy(
            type = type
        )
    }
    fun setMinPlayers(minPlayers: Int) {
        _game.value = _game.value.copy(
            minPlayers = minPlayers
        )
    }
    fun setMaxPlayers(maxPlayers: Int) {
        _game.value = _game.value.copy(
            maxPlayers = maxPlayers
        )
    }
    fun setDuration(duration: Int) {
        _game.value = _game.value.copy(
            duration = duration
        )
    }
    fun setCreator(creator: String) {
        _game.value = _game.value.copy(
            creator = creator
        )
    }
    fun update(){
        viewModelScope.launch{
            modifyGameUseCase(game.value)
        }
    }
}
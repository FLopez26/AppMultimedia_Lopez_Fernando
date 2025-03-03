package com.example.appmultimedia_lopez_fernando.presentation.viewmodel.games

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appmultimedia_lopez_fernando.domain.model.Game
import com.example.appmultimedia_lopez_fernando.domain.usecase.games.RandomGameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RandomGameViewModel(
    val randomGameUseCase: RandomGameUseCase
) : ViewModel() {
    private val _game = MutableStateFlow(
        Game("", "","","",0,0,0,"")
    )
    val game: StateFlow<Game> = _game

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

//    fun find(type: String,minPlayers: Int,maxPlayers: Int,duration: Int,creator: String): Game?{
//        var game : Game? = null
//        viewModelScope.launch {
//            game = randomGameUseCase(type,minPlayers,maxPlayers,duration,creator)
//        }
//        game?.let { setName(it.name) }
//        game?.let { setLocation(it.location) }
//        return game
//    }
fun find(type: String, minPlayers: Int, maxPlayers: Int, duration: Int, creator: String): Unit {
    viewModelScope.launch {
        val gameResult: Game? = randomGameUseCase(type, minPlayers, maxPlayers, duration, creator)
        if (gameResult != null) {
            _game.value = gameResult
        } else {
            _game.value = Game("", "", "", "", 0, 0, 0, "")
        }
    }
}
}
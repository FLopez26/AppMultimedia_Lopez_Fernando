package com.appmultimedia_lopez_fernando.presentation.viewmodel.games

import androidx.lifecycle.ViewModel
import com.appmultimedia_lopez_fernando.domain.model.Game
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GamesViewModel: ViewModel() {
    private val _games = MutableStateFlow(
        listOf(
            Game("Carcassonne", "Salón", "Losetas", 2, 5, 30, "Klaus-Jürgen Wrede"),
            Game("Catan", "Estantería", "Comercio", 3, 4, 90, "Klaus Teuber"),
            Game("The Red Cathedral", "Salón", "Mayorías", 1, 4, 60, " Israel Cendrero"),
            Game("Sagrada", "Salón", "Construcción", 1, 4, 30, "Adrian Adamescu"),
            Game("Ubongo!", "Salón", "Puzzle", 1, 4, 30, "Grzegorz Rejchtman"),
            Game("Alhambra", "Estantería", "Losetas", 2, 6, 60, "Dirk Henn")
        )
    )

    val games: StateFlow<List<Game>> = _games

    fun addGame(game: Game){
        _games.value += game
    }

    fun removeGame(name: String){
        _games.value = _games
            .value
            .filter { it.name != name}
    }
}
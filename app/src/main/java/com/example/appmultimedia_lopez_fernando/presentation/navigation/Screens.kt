package com.example.appmultimedia_lopez_fernando.presentation.navigation

import com.example.appmultimedia_lopez_fernando.domain.model.Game

// Dentro de la sealed class definimos un object por cada ruta existenten
sealed class Screen(val route: String) {
    data object Main : Screen("mainView")
    data object Login : Screen("login")
    data object CreateGame : Screen("createGame")
    data object ModifyGame : Screen("modifyGame/{id}") {
        fun createRoute(id: String) = "modifyGame/$id"
    }
    data object RandomGame : Screen("randomGame")
}
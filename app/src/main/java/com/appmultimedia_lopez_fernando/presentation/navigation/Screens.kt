package com.appmultimedia_lopez_fernando.presentation.navigation

// Dentro de la sealed class definimos un object por cada ruta existenten
sealed class Screen(val route: String) {
    data object Home : Screen("mainView")
    data object Login : Screen("login")
    data object CreateGame : Screen("createGame")
}
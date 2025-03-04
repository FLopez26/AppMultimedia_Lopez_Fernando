package com.example.appmultimedia_lopez_fernando.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appmultimedia_lopez_fernando.presentation.ui.screens.games.CreateGameScreen
import com.example.appmultimedia_lopez_fernando.presentation.ui.screens.games.ModifyGameScreen
import com.example.appmultimedia_lopez_fernando.presentation.ui.screens.games.RandomGameScreen
import com.example.appmultimedia_lopez_fernando.presentation.ui.screens.login.LoginScreen
import com.example.appmultimedia_lopez_fernando.presentation.ui.screens.mainView.mainViewScreen

// El startDestination define la pantalla que se cargará cuando se abre la aplicación
@Composable
fun NavGraph(startDestination: String = Screen.Login.route) {
    // Cargamos el navController
    val navController = rememberNavController()

    // Creamos un NavHost que arranque con la pantalla de inicio
    NavHost(navController = navController, startDestination = startDestination) {

        composable(Screen.Main.route) {
            mainViewScreen(navController)
        }

        composable(Screen.Login.route) {
            LoginScreen(navController)
        }

        composable(Screen.CreateGame.route) {
            CreateGameScreen(navController)
        }

        composable(Screen.ModifyGame.route) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            ModifyGameScreen(navController, id!!)
        }

        composable(Screen.RandomGame.route) {
            RandomGameScreen(navController)
        }
    }
}
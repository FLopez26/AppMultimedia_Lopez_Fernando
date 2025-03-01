package com.example.appmultimedia_lopez_fernando.presentation.ui.screens.mainView

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appmultimedia_lopez_fernando.presentation.navigation.Screen
import com.example.appmultimedia_lopez_fernando.presentation.ui.components.ActionsMenu
import com.example.appmultimedia_lopez_fernando.presentation.ui.components.GameCard
import com.example.appmultimedia_lopez_fernando.presentation.viewmodel.games.GamesScreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun mainViewScreen(
    navController: NavController,
    gamesViewModel: GamesScreenViewModel = koinViewModel()
){
    val snackbarHostState = remember { SnackbarHostState() }
    val games = gamesViewModel.games.collectAsState().value
    var showDialog by remember { mutableStateOf(false) }
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding(),
        topBar = {
            ActionsMenu(navController = navController)
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Screen.CreateGame.route) }) {
                Text("+")
            }
        },
        content = { innerPadding ->
            Column {
                LazyColumn(
                    Modifier.padding(innerPadding),
                    verticalArrangement = Arrangement.Center
                ) {
                    items(games) { game ->
                        key(game) {
                            GameCard(game,navController ,gamesViewModel)
                            Spacer(modifier = Modifier.height(10.dp))
                        }
                    }
                }
            }
        }

    )
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = "Título del Diálogo") },
            text = { Text("Este es un mensaje dentro del diálogo.") },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Aceptar")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Cancelar")
                }
            }
        )
    }
}



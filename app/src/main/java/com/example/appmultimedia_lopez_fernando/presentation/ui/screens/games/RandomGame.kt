package com.example.appmultimedia_lopez_fernando.presentation.ui.screens.games

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appmultimedia_lopez_fernando.presentation.navigation.Screen
import com.example.appmultimedia_lopez_fernando.presentation.viewmodel.games.RandomGameViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun RandomGameScreen(
    navController: NavController,
    randomGameViewModel: RandomGameViewModel = koinViewModel()
) {
    val game by randomGameViewModel.game.collectAsState()
    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }
    var dialogTitle by remember { mutableStateOf("") }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = dialogTitle) },
            text = { Text(dialogMessage) },
            confirmButton = {
                Button(onClick = { showDialog = false; navController.navigate(Screen.Main.route) }) {
                    Text("Aceptar")
                }
            }
        )
    }

    Scaffold { innerPadding ->
        Column(
            Modifier.padding(innerPadding)
        ) {
            Text(
                modifier = Modifier
                    .padding(30.dp)
                    .align(Alignment.CenterHorizontally),
                text = "¿A qué jugar?",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1,
                value = game.type,
                onValueChange = {
                    randomGameViewModel.setType(it)
                },
                label = { Text("Tipo") }
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "    Cantidad de Jugadores",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                TextField(
                    modifier = Modifier.fillMaxWidth(0.45f),
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    value = game.minPlayers.toString(),
                    onValueChange = { newId ->
                        newId.toIntOrNull()?.let {
                            randomGameViewModel.setMinPlayers(it)
                        }
                    },
                    label = { Text("Mínimos") }
                )
                Spacer(modifier = Modifier.fillMaxWidth(0.1f))
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    value = game.maxPlayers.toString(),
                    onValueChange = { newId ->
                        newId.toIntOrNull()?.let {
                            randomGameViewModel.setMaxPlayers(it)
                        }
                    },
                    label = { Text("Máximos") }
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(0.65f),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                value = game.duration.toString(),
                onValueChange = { newId ->
                    newId.toIntOrNull()?.let {
                        randomGameViewModel.setDuration(it)
                    }
                },
                label = { Text("Duración Media (minutos)") }
            )
            Spacer(modifier = Modifier.height(25.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1,
                value = game.creator,
                onValueChange = {
                    randomGameViewModel.setCreator(it)
                },
                label = { Text("Nombre del Creador") }
            )

            Spacer(modifier = Modifier.weight(1f))

            Button( onClick = {
                randomGameViewModel.find(
                    type = game.type,
                    minPlayers = game.minPlayers,
                    maxPlayers = game.maxPlayers,
                    duration = game.duration,
                    creator = game.creator
                )
            },
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(16.dp)
            ) {
                Text(text = "Buscar")
            }
        }
    }

    LaunchedEffect(game) {
        if (game.name.isNotBlank() || game.location.isNotBlank()) {
            if (game.name.isNotBlank()) {
                dialogTitle = "Juego seleccionado"
                dialogMessage = "Nombre: ${game.name}\nUbicación: ${game.location}"
            } else {
                dialogTitle = "No se encontraron juegos"
                dialogMessage = "No existe ningún juego con esas carácterísticas"
            }
            showDialog = true
        }
    }
}
package com.example.appmultimedia_lopez_fernando.presentation.ui.screens.games

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appmultimedia_lopez_fernando.presentation.navigation.Screen
import com.example.appmultimedia_lopez_fernando.presentation.viewmodel.games.AddGameViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CreateGameScreen(
    navController: NavController,
    addGameViewModel :AddGameViewModel = koinViewModel()
) {
    val game by addGameViewModel.game.collectAsState()
    Scaffold { innerPadding ->
        Column(
            Modifier.padding(innerPadding)
        ) {
            Text(
                modifier = Modifier
                    .padding(30.dp)
                    .align(Alignment.CenterHorizontally),
                text = "Añadir Juego de Mesa",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1,
                value = game.name,
                onValueChange = {
                    addGameViewModel.setName(it)
                },
                label = { Text("Nombre") }
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1,
                value = game.location,
                onValueChange = {
                    addGameViewModel.setLocation(it)
                },
                label = { Text("Ubicación") }
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1,
                value = game.type,
                onValueChange = {
                    addGameViewModel.setType(it)
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
                            addGameViewModel.setMinPlayers(it)
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
                            addGameViewModel.setMaxPlayers(it)
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
                        addGameViewModel.setDuration(it)
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
                    addGameViewModel.setCreator(it)
                },
                label = { Text("Nombre del Creador") }
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    addGameViewModel.save()
                    navController.navigate(Screen.Main.route) },
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(16.dp)
            ) {
                Text(text = "Añadir")
            }
        }
    }
    }
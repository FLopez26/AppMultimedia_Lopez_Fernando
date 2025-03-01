package com.example.appmultimedia_lopez_fernando.presentation.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.appmultimedia_lopez_fernando.domain.model.Game
import com.example.appmultimedia_lopez_fernando.presentation.viewmodel.games.GamesScreenViewModel
import com.example.appmultimedia_lopez_fernando.presentation.viewmodel.games.RemoveGameViewModel
import org.koin.androidx.compose.koinViewModel

@SuppressLint("NotConstructor")
@Composable
fun GameCard(
    game: Game,
    gamesViewModel: GamesScreenViewModel,
    removeGameViewModel: RemoveGameViewModel = koinViewModel()
) {
    var expanded by remember { mutableStateOf(false) }
    Card(onClick = { expanded = !expanded }, modifier = Modifier
        .fillMaxWidth()
        .padding(start = 10.dp, end = 10.dp)
    ){
        Column(
            Modifier
                .padding(10.dp)
        ){
            Row {
                Icon(
                    imageVector = if (expanded) Icons.Default.Remove else Icons.Default.Add,
                    contentDescription = "Exandir",
                    modifier = Modifier.clickable {
                        expanded = !expanded
                    }
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = game.name,
                    fontWeight = if (expanded) FontWeight.Bold else FontWeight.Normal
                )
            }
            if (expanded) {
                //Location
                Row(
                    modifier = Modifier.offset(20.dp)
                ){
                    Text(text = "Ubicación: ",
                        fontWeight = FontWeight.SemiBold)
                    Text(text = game.name)
                }
                //Type
                Row(
                    modifier = Modifier.offset(20.dp)
                ){
                    Text(text = "Tipo de juego: ",
                        fontWeight = FontWeight.SemiBold)
                    Text(text = game.type)
                }
                //Players
                Row(
                    modifier = Modifier.offset(20.dp)
                ){
                    Text(text = "Jugadores: ",
                        fontWeight = FontWeight.SemiBold)
                    Text(text = "${game.minPlayers} / ${game.maxPlayers}")
                }
                //Duration
                Row(
                    modifier = Modifier.offset(20.dp)
                ){
                    Text(text = "Duración (min): ",
                        fontWeight = FontWeight.SemiBold)
                    Text(text = "${game.duration}")
                }
                //Creator
                Row(
                    modifier = Modifier.offset(20.dp)
                ){
                    Text(text = "Creador: ",
                        fontWeight = FontWeight.SemiBold)
                    Text(text = game.creator)
                }
                //Buttons
                Row{
                    IconButton(onClick = { removeGameViewModel.delete(game.id) }) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Icono de eliminar"
                        )
                    }
                    IconButton(onClick = {  }) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Icono de editar"
                        )
                    }
                }
            }
        }
    }
}
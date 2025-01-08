package com.appmultimedia_lopez_fernando.presentation.ui.screens.games

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.appmultimedia_lopez_fernando.presentation.navigation.Screen

@Composable
fun CreateGameScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var place by remember { mutableStateOf("") }
    var type by remember { mutableStateOf("") }
    var maxPlayer by remember { mutableStateOf("") }
    var minPlayer by remember { mutableStateOf("") }
    var duration by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
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
                value = name,
                onValueChange = { newText -> name = newText },
                label = { Text("Nombre") }
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = place,
                onValueChange = { newText -> place = newText },
                label = { Text("Ubicación") }
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = type,
                onValueChange = { newText -> type = newText },
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
                    value = minPlayer,
                    onValueChange = { newText -> minPlayer = newText },
                    label = { Text("Mínimos") }
                )
                Spacer(modifier = Modifier.fillMaxWidth(0.1f))
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = maxPlayer,
                    onValueChange = { newText -> maxPlayer = newText },
                    label = { Text("Máximos") }
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(0.65f),
                value = duration,
                onValueChange = { newText -> duration = newText },
                label = { Text("Duración Media (minutos)") }
            )
            Spacer(modifier = Modifier.height(25.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = author,
                onValueChange = { newText -> author = newText },
                label = { Text("Nombre del Creador") }
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { navController.navigate(Screen.Home.route) },
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(16.dp)
            ) {
                Text(text = "Crear")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreateGamePreview(){
}
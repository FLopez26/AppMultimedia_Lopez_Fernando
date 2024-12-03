package com.appmultimedia_lopez_fernando.presentation.ui.screens.games

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CreateGameScreen(){
    var name by remember { mutableStateOf("")}

    Surface (modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding())
    {
        Column(
            Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Text(
                text = "Añadir Juego de Mesa",
                style = TextStyle(
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField( modifier = Modifier
                .fillMaxWidth(),
                value = name,
                onValueChange = { newText -> name = newText },
                label = { Text("Nombre del Juego")}
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField( modifier = Modifier
                .fillMaxWidth(),
                value = name,
                onValueChange = { newText -> name = newText },
                label = { Text("Nombre del Juego")}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreateGamePreview(){
    CreateGameScreen()
}
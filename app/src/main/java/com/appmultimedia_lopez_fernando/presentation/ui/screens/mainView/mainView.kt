package com.appmultimedia_lopez_fernando.presentation.ui.screens.mainView

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainViewScreen(){
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding(),
        topBar = {
            TopAppBar( modifier = Modifier.padding(25.dp),
                title = {
                    Text(
                        text = "Añadir Juego de Mesa",
                        style = TextStyle(
                            fontSize = 30.sp,
                            fontWeight = FontWeight.ExtraBold
                        ),
                        modifier = Modifier
                            .fillMaxWidth() // Ocupa todo el ancho disponible
                            .padding(30.dp),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Acción del FAB */ }) {
                Text("+")
            }
        },
        content = { paddingValues ->
            Text(
                text = "Contenido del cuerpo",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun mainViewPreview(){
    mainViewScreen()
}
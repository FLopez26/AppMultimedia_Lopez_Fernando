package com.appmultimedia_lopez_fernando.presentation.ui.screens.mainView

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.appmultimedia_lopez_fernando.presentation.navigation.Screen
import com.example.appmultimedia_lopez_fernando.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainViewScreen(navController: NavController){
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding(),
        topBar = {
            TopAppBar(
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.logo_app),
                        contentDescription = "Logo",
                        modifier = Modifier.size(500.dp)

                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Screen.CreateGame.route) }) {
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
}
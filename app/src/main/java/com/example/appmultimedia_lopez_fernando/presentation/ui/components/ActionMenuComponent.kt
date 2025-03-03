package com.example.appmultimedia_lopez_fernando.presentation.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appmultimedia_lopez_fernando.presentation.navigation.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActionsMenu(navController: NavController) {

    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text("Bilbioteca") },
        actions = {
            IconButton(onClick = { expanded = true }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menú"
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = {
                        Text("Añadir juego")
                    },
                    onClick = {
                        expanded = false
                        navController.navigate(Screen.CreateGame.route)
                    }
                )

                DropdownMenuItem(
                    text = {
                        Text("A que jugar")
                    },
                    onClick = {
                        expanded = false
                        navController.navigate(Screen.RandomGame.route)
                    }
                )

                HorizontalDivider()

                DropdownMenuItem(
                    text = { Text("Cerrar sesión") },
                    onClick = {
                        expanded = false
                        navController.navigate(Screen.Login.route)
                    })
            }
        }
    )
}

@Preview
@Composable
fun ActionsMenuPreview() {
    ActionsMenu(rememberNavController())
}
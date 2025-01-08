package com.appmultimedia_lopez_fernando.presentation.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.appmultimedia_lopez_fernando.presentation.navigation.Screen
import com.example.appmultimedia_lopez_fernando.R

@Composable
fun LoginScreen(navController: NavController) {
    var username by remember { mutableStateOf("")}
    var passwordVisible by remember { mutableStateOf(false) }
    var password by remember { mutableStateOf("")}

    Surface(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding())
    {
        Column (modifier = Modifier
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Spacer(modifier = Modifier.height(75.dp))
            Image(
                painter = painterResource(id = R.drawable.logo_app),
                contentDescription = "Logo",
                modifier = Modifier.size(300.dp)

            )
            Spacer(modifier = Modifier.height(40.dp))
            TextField(
                modifier = Modifier.fillMaxWidth()
                    .padding(20.dp,0.dp),
                value = username,
                onValueChange = { newText -> username = newText },
                label = { Text("Username") }
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                modifier = Modifier.fillMaxWidth()
                    .padding(20.dp,0.dp),
                value = password,
                onValueChange = { newPassword -> password = newPassword },
                label = { Text("Password") },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val imagen = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = imagen, contentDescription = null)
                    }
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row()
            {
                Button(onClick = {username = ""; password = ""}){
                    Text(text = "Clean")
                }

                Spacer(modifier = Modifier.width(10.dp))

                Button(onClick = {navController.navigate(Screen.CreateGame.route)}) {
                Text(text = "Login")
                }
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
}
package com.example.iniciodesesionconnav.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun RegisterScreen(navController: NavController) {

    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var pass1 by remember { mutableStateOf("") }
    var pass2 by remember { mutableStateOf("") }

    val nombreValido = nombre.matches(Regex("^[a-zA-Z ]+$"))
    val correoValido = correo.matches(Regex("^[A-Za-z0-9+_.-]+@(.+)$"))
    val telefonoValido = telefono.matches(Regex("^\\d{10}$"))
    val passIguales = pass1 == pass2 && pass1.isNotEmpty()

    val formularioValido =
        nombreValido && correoValido && telefonoValido && passIguales

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text("Registro")

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") }
        )

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo") }
        )

        OutlinedTextField(
            value = telefono,
            onValueChange = { telefono = it },
            label = { Text("Teléfono") }
        )

        OutlinedTextField(
            value = pass1,
            onValueChange = { pass1 = it },
            label = { Text("Contraseña") }
        )

        OutlinedTextField(
            value = pass2,
            onValueChange = { pass2 = it },
            label = { Text("Confirmar contraseña") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate("welcome") },
            enabled = formularioValido
        ) {
            Text("Aceptar")
        }

    }
}
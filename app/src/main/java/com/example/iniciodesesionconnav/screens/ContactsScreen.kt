package com.example.iniciodesesionconnav.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class Contact(val nombre: String, val telefono: String, val color: Color)

@Composable
fun ContactsScreen(navController: NavController) {

    var nombre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }

    var contactos by remember {
        mutableStateOf(
            listOf(
                Contact("Ana García", "+34 612 345 678", Color(0xFF6E9AFE)),
                Contact("Carlos Rodríguez", "+34 699 888 777", Color(0xFF4CAF50)),
                Contact("Elena Martínez", "+34 655 443 322", Color(0xFFFF9800))
            )
        )
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text("Mis Contactos", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = telefono,
            onValueChange = { telefono = it },
            label = { Text("Teléfono") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(
                onClick = {
                    if (nombre.isNotBlank() && telefono.isNotBlank()) {
                        contactos = contactos + Contact(nombre, telefono, Color.Gray)
                        nombre = ""
                        telefono = ""
                    }
                }
            ) {
                Text("Agregar Contacto")
            }

            OutlinedButton(onClick = {
                nombre = ""
                telefono = ""
            }) {
                Text("Limpiar Campos")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(contactos) { c ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(c.color, shape = CircleShape)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Column {
                        Text(c.nombre, fontWeight = FontWeight.SemiBold)
                        Text(c.telefono, color = Color.Gray)
                    }
                }
                Divider()
            }
        }
    }
}
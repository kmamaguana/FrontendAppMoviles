package com.example.vetcare.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.vetcare.R
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun ChatBotScreen(navController: NavController) {
    var messages by remember { mutableStateOf(listOf<String>("¡Hola! Soy tu asistente VetCare. ¿En qué puedo ayudarte?")) }
    var inputText by remember { mutableStateOf(TextFieldValue("")) }

    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo
        Image(
            painter = painterResource(id = R.drawable.login_background),
            contentDescription = "Fondo ChatBot",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(
                    color = MaterialTheme.colorScheme.surface.copy(alpha = 0.85f),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp)
        ) {
            Text(
                text = "Asistente Bot",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Área de mensajes con scroll
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                for (msg in messages) {
                    Text(
                        text = msg,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                            .fillMaxWidth()
                    )
                }
            }

            // Campo para escribir mensaje y botón enviar
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = inputText,
                    onValueChange = { inputText = it },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("Escribe tu mensaje...") },
                    maxLines = 1,
                    singleLine = true
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = {
                    if (inputText.text.isNotBlank()) {
                        // Agregar el mensaje del usuario
                        messages = messages + "Tú: ${inputText.text}"

                        // Simular respuesta simple (puedes reemplazar con lógica real)
                        messages = messages + "Bot: Lo siento, estoy aprendiendo y no puedo responder eso aún."

                        inputText = TextFieldValue("") // Limpiar campo
                    }
                }) {
                    Text("Enviar")
                }
            }
        }
    }
}

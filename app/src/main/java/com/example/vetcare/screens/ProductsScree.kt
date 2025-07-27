package com.example.vetcare.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.vetcare.R

data class Producto(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val imageRes: Int
)

@Composable
fun ProductsScreen() {
    val productos = listOf(
        Producto(1, "Vacuna Antirrábica", "Vacuna anual para perros y gatos", R.drawable.ic_vacuna),
        Producto(2, "Desparasitante", "Desparasitante interno para cachorros", R.drawable.ic_desparasitante),
        Producto(3, "Shampoo Medicado", "Para piel sensible y alergias", R.drawable.ic_shampoo),
        Producto(4, "Croquetas Premium", "Alimento balanceado para adultos", R.drawable.ic_croquetas)
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Fondo con imagen
        Image(
            painter = painterResource(id = R.drawable.login_background),
            contentDescription = "Fondo Productos",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Contenedor blanco para título + grid, centrado y con padding
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.White, shape = MaterialTheme.shapes.medium)
                .clip(MaterialTheme.shapes.medium)
                .padding(16.dp)
                .align(Alignment.Center), // Centrado en pantalla
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Productos",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp) // Ajusta altura según necesidad
            ) {
                items(productos) { producto ->
                    ProductCard(producto)
                }
            }
        }
    }
}

@Composable
fun ProductCard(producto: Producto) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = producto.imageRes),
                contentDescription = producto.nombre,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(80.dp)
            )
            Text(
                text = producto.nombre,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black
            )
            Text(
                text = producto.descripcion,
                style = MaterialTheme.typography.bodySmall,
                color = Color.DarkGray
            )
        }
    }
}

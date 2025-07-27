import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.vetcare.R
import com.example.vetcare.navigation.Screens

data class HomeOption(
    val title: String,
    val imageRes: Int,
    val onClick: () -> Unit
)

@Composable
fun HomeScreen(navController: NavController) {
    val options = listOf(
        HomeOption("Productos", R.drawable.ic_productos) {
            navController.navigate(Screens.Products.route)
        },
        HomeOption("Clientes", R.drawable.ic_clientes) {
            navController.navigate(Screens.Clients.route)
        },
        HomeOption("Calendario", R.drawable.ic_calendario) {
            navController.navigate(Screens.Calendar.route)  // <-- Aquí la navegación corregida
        },
        HomeOption("Recordatorios", R.drawable.ic_recordatorios) {
            navController.navigate(Screens.Reminders.route)
        },
        HomeOption("Asistente Bot", R.drawable.ic_chatbot) {  // Nuevo servicio agregado
            navController.navigate(Screens.ChatBot.route)  // Debes crear esta pantalla y ruta
        }


    )

    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo
        Image(
            painter = painterResource(id = R.drawable.login_background),
            contentDescription = "Fondo Home",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background.copy(alpha = 0.9f), shape = RoundedCornerShape(12.dp))
                    .padding(16.dp)
                    .clip(RoundedCornerShape(12.dp))
            ) {
                Text(
                    text = "Bienvenido a VetCare",
                    style = MaterialTheme.typography.headlineLarge, // Más grande que headlineMedium
                    modifier = Modifier.align(Alignment.Center),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }


            // Grid centrado y con tamaño limitado
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // 🟢 Para que el grid use el espacio restante del Column
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    userScrollEnabled = true, // ✅ Activamos scroll
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 16.dp)
                ) {
                    items(options) { option ->
                        HomeOptionCard(option)
                    }
                }
            }

        }
    }
}

@Composable
fun HomeOptionCard(option: HomeOption) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clickable(onClick = option.onClick),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.85f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagen más grande
            Image(
                painter = painterResource(id = option.imageRes),
                contentDescription = option.title,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(80.dp) // Aumentado a 80dp
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(option.title, style = MaterialTheme.typography.titleMedium)
        }
    }
}

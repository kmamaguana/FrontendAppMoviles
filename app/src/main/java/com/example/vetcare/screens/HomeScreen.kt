import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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

@Composable
fun HomeScreen(navController: NavController) {
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
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Bienvenido a VetCare",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Calendario
            SectionCard(title = "Calendario") {
                Text("Aquí irán las citas y eventos programados.")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Productos (con navegación)
            SectionCard(
                title = "Productos",
                modifier = Modifier.clickable {
                    navController.navigate(Screens.Products.route)
                }
            ) {
                Text("Listado de productos disponibles.")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Clientes (con navegación)
            SectionCard(
                title = "Clientes",
                modifier = Modifier.clickable {
                    navController.navigate(Screens.Clients.route)
                }
            ) {
                Text("Lista y detalles de tus clientes.")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Recordatorios
            SectionCard(title = "Recordatorios") {
                Text("Tus recordatorios importantes.")
            }
        }
    }
}

@Composable
fun SectionCard(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp)),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.85f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            content()
        }
    }
}


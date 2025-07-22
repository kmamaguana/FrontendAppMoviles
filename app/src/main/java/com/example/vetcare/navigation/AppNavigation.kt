package com.example.vetcare.navigation

import HomeScreen
import LoginScreen
import com.example.vetcare.screens.ClientsScreen
import com.example.vetcare.screens.ProductsScreen
import com.example.vetcare.screens.RegisterScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

// Define rutas
sealed class Screens(val route: String) {
    object Login : Screens("login")
    object Register : Screens("register")
    object Home : Screens("home")
    object Clients : Screens("clients")
    object Products : Screens("products") // ✅ Nueva ruta para la pantalla de productos
}

@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Login.route,
        modifier = modifier
    ) {
        composable(Screens.Login.route) {
            LoginScreen(navController)
        }
        composable(Screens.Register.route) {
            RegisterScreen(navController)
        }
        composable(Screens.Home.route) {
            HomeScreen(navController)
        }
        composable(Screens.Register.route) {
            RegisterScreen(navController)
        }

        composable(Screens.Clients.route) {
            ClientsScreen(
                onClientClick = { cliente ->
                    // Puedes manejar acciones con el cliente aquí si deseas
                }
            )
        }
        composable(Screens.Products.route) {
            ProductsScreen() // ✅ Pantalla de productos
        }
    }
}

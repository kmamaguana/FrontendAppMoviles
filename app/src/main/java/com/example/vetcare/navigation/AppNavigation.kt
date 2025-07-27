package com.example.vetcare.navigation

import HomeScreen
import LoginScreen
import com.example.vetcare.screens.CalendarScreen
import com.example.vetcare.screens.ClientsScreen
import com.example.vetcare.screens.ProductsScreen
import com.example.vetcare.screens.RegisterScreen
import com.example.vetcare.screens.UserTypeSelectionScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.vetcare.screens.ChatBotScreen
import com.example.vetcare.screens.RemindersScreen

// Define rutas
sealed class Screens(val route: String) {
    object UserTypeSelectionScreen : Screens("user_type_selection") // ✅ Nueva ruta agregada
    object Login : Screens("login")
    object Register : Screens("register")
    object Home : Screens("home")
    object Clients : Screens("clients")
    object Products : Screens("products") // ✅ Pantalla de productos
    object Calendar : Screens("calendar") // ✅ Nueva ruta para Calendario
    object Reminders : Screens("reminders")
    object ChatBot : Screens("chatbot")

}

@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screens.UserTypeSelectionScreen.route, // ✅ Ahora inicia en selección de tipo de usuario
        modifier = modifier
    ) {
        // Pantalla inicial para seleccionar tipo de usuario
        composable(Screens.UserTypeSelectionScreen.route) {
            UserTypeSelectionScreen(navController)
        }

        composable(Screens.Login.route) {
            LoginScreen(navController)
        }
        composable(Screens.Register.route) {
            RegisterScreen(navController)
        }
        composable(Screens.Home.route) {
            HomeScreen(navController)
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

        composable(Screens.Calendar.route) { // ✅ Nueva pantalla Calendario
            CalendarScreen()
        }
        composable(Screens.Reminders.route) {
            RemindersScreen()
        }
        composable(Screens.ChatBot.route) {
            ChatBotScreen(navController)
        }

    }
}

package com.example.iniciodesesionconnav.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.iniciodesesionconnav.screens.LoginScreen
import com.example.iniciodesesionconnav.screens.RegisterScreen
import com.example.iniciodesesionconnav.screens.WelcomeScreen

@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {

        composable("welcome") {
            WelcomeScreen(navController)
        }

        composable("login") {
            LoginScreen(navController)
        }

        composable("register") {
            RegisterScreen(navController)
        }

    }
}
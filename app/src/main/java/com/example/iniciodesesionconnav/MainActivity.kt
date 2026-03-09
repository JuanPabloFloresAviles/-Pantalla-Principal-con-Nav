package com.example.iniciodesesionconnav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.iniciodesesionconnav.navigation.AppNavigation
import com.example.iniciodesesionconnav.ui.theme.InicioDeSesionConNavTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            InicioDeSesionConNavTheme {

                val navController = rememberNavController()

                AppNavigation(navController)

            }
        }
    }
}
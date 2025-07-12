package com.example.khulasaquran.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.khulasaquran.util.BottomNavigationBar
import com.example.khulasaquran.util.Screen

@Composable
fun KhulasaQuranApp() {
    val navController = rememberNavController()
    val currentRoute by navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            if (currentRoute?.destination?.route in listOf(Screen.Home.route, Screen.Profile.route)) {
                BottomNavigationBar(navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Splash.route) { FirstScreen(navController) }
            composable(Screen.Home.route) { HomeScreen(navController) }

            // 🔸 Dynamic route to pass PDF file name
            composable(
                route = "para/{filename}",
                arguments = listOf(navArgument("filename") { type = NavType.StringType })
            ) { backStackEntry ->
                val fileName = backStackEntry.arguments?.getString("filename") ?: "para1.pdf"
                ParaScreen(navController, fileName)
            }

            composable(Screen.Writer.route) { ParaScreen(navController, "writer.pdf") }
            composable(Screen.Profile.route) { ProfileScreen(navController) }
            composable(Screen.Favourites.route) { FavouritesScreen() }
        }

    }
}

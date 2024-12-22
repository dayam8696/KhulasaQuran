package com.example.khulasaquran.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion.SideEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.khulasaquran.ui.theme.KhulasaQuranTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KhulasaQuranTheme {
                 KhulasaQuranApp()
            }
        }
    }

    @Composable
    fun KhulasaQuranApp(modifier: Modifier = Modifier) {
        val systemUiController = rememberSystemUiController()
        val navController = rememberNavController()
        SideEffect {
            systemUiController.setStatusBarColor(color = Color(0xFF2C200A))
        }
        NavHost(navController = navController, startDestination = "first_screen") {
            composable("first_screen") { FirstScreen(navController) }
            composable("para_screen") { ParaScreen(navController) }
        }
    }
}



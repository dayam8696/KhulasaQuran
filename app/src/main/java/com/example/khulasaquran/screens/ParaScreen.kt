package com.example.khulasaquran.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ParaScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) {paddingValues ->
        Column(
            Modifier
                .background(color = Color(0xFF968B76))
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Khulasa Quran",
                color = Color.Black
            )
            LazyColumn(
                Modifier.fillMaxWidth().padding(vertical = 8.dp)
            ) {
                items(30) {
                    ParaItem("Para ${it+1}")
                    Spacer(Modifier.height(10.dp))
                }
            }
        }
    }
}

@Composable
fun ParaItem(title : String) {
    Box(
        modifier = Modifier.background(
            color = Color(0xFFB7AE9F),
            shape = RoundedCornerShape(8.dp)
        ).fillMaxWidth().height(50.dp),
        contentAlignment = Alignment.CenterStart
    ){
        Text(
            text = title,
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier.padding(8.dp),
            textAlign = TextAlign.Start
        )
    }
}
@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(
        containerColor = Color(0xFFB7AE9F)
    ) {
        NavigationBarItem(
            selected = true, // Manage selection state dynamically
            onClick = { /* Handle navigation to Home */ },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = false, // Manage selection state dynamically
            onClick = { /* Handle navigation to Favorites */ },
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorites"
                )
            },
            label = { Text("Favorites") }
        )
        NavigationBarItem(
            selected = false, // Manage selection state dynamically
            onClick = { /* Handle navigation to Settings */ },
            icon = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings"
                )
            },
            label = { Text("Settings") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ParaScreenPreview() {
    ParaScreen(navController = rememberNavController())
}

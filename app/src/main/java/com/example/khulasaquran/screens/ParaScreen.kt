package com.example.khulasaquran.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ParaScreen() {
    Column(
        Modifier.background(color = Color(0xFF968B76)).fillMaxSize()
    ) {
        Text(
            text = "Khulasa Quran",
            color = Color.Black
        )
        LazyColumn(
            Modifier.fillMaxWidth()
        ) {
            items(30) {
                Text(
                    text = "Para $it",
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ParaScreenPreview(){
    ParaScreen()
}
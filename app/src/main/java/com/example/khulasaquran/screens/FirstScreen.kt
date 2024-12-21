package com.example.khulasaquran.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FirstScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom, // Ensures content is at the bottom
        horizontalAlignment = Alignment.CenterHorizontally // Align buttons horizontally
    ) {
        Button(
            onClick = { /* TODO: First Button Action */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Button 1")
        }

        Spacer(modifier = Modifier.height(8.dp)) // Add space between buttons

        Button(
            onClick = { /* TODO: Second Button Action */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Button 2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFirstScreen() {
    FirstScreen()
}

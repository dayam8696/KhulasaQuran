@file:Suppress("UNREACHABLE_CODE")

package com.example.khulasaquran.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.khulasaquran.R
@Composable
fun FirstScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Image Section
        Image(
            painter = painterResource(id = R.drawable.home_image), // Replace with your drawable name
            contentDescription = "Descriptive text for your image",
            modifier = Modifier
                .weight(1f)// Occupies the remaining space above the buttons
                .fillMaxWidth() // Makes the image fill the width
        )

        // Buttons Section
        Column(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { /* TODO: First Button Action */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonColors(
                    contentColor = Color(0xD2B26536),
                    containerColor = TODO(),
                    disabledContainerColor = TODO(),
                    disabledContentColor = TODO()
                )
            ) {
                Text("Button 1")
            }

            Spacer(modifier = Modifier.height(8.dp)) // Space between buttons

            Button(
                onClick = { /* TODO: Second Button Action */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Button 2")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFirstScreen() {
    FirstScreen()
}




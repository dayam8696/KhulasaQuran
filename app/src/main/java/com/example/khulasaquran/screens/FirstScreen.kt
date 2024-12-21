package com.example.khulasaquran.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.khulasaquran.R

@Composable
fun FirstScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFF2F1E04))
            .padding(2.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.home_image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            colors = ButtonColors(
                containerColor = Color(0xD2B26536),
                contentColor = Color.White,
                disabledContentColor = Color.White,
                disabledContainerColor = Color(0xD2B26536)
            ),
            modifier = Modifier.fillMaxWidth(),
            onClick = {}
        ) {
            Text(
                text = "Start",
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFirstScreen() {
    FirstScreen()
}




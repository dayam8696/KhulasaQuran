package com.example.khulasaquran.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.khulasaquran.R

@Composable
fun FirstScreen(modifier: Modifier = Modifier) {
    Column {
        Image(painter = painterResource(R.drawable.home_image), contentDescription = null)
    }
}
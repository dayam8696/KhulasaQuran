package com.example.khulasaquran.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.khulasaquran.R

@Composable
fun FirstScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF2C200A))
            .padding(2.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.home_image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            colors = ButtonColors(
                containerColor = Color(0xFF513D18),
                contentColor = Color.White,
                disabledContentColor = Color.White,
                disabledContainerColor = Color(0xFF513D18)
            ),
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(50.dp)
                .align(Alignment.CenterHorizontally),


            onClick = {navController.navigate("para_screen")}
        ) {
            Text(
                text = "START",
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            colors = ButtonColors(
                containerColor = Color(0xFF513D18),
                contentColor = Color.White,
                disabledContentColor = Color.White,
                disabledContainerColor = Color(0xFF513D18)
            ),
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(50.dp)
                .align(Alignment.CenterHorizontally),


            onClick = {}
        ) {
            Text(
                text = "ABOUT THE WRITTER",
                color = Color.White
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun firstscreenPreview() {
    FirstScreen(navController = rememberNavController())
}



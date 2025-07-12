package com.example.khulasaquran.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val listState = rememberLazyListState()

    // Para data with Urdu names for better UX
    val paraList = remember {
        listOf(
            "Para 1 - Alif Laam Meem",
            "Para 2 - Sayaqool",
            "Para 3 - Tilkal Rusul",
            "Para 4 - Lan Tanaloo",
            "Para 5 - Wal Mohsanaat",
            "Para 6 - La Yuhibbullah",
            "Para 7 - Wa Iza Samiu",
            "Para 8 - Wa Lau Annana",
            "Para 9 - Qalal Malao",
            "Para 10 - Wa A'lamoo",
            "Para 11 - Yatazeroon",
            "Para 12 - Wa Maa Min Daabbah",
            "Para 13 - Wa Maa Ubrioo",
            "Para 14 - Rubamaa",
            "Para 15 - Subhanal Lazi",
            "Para 16 - Qaal Alam",
            "Para 17 - Aqtarabat",
            "Para 18 - Qad Aflaha",
            "Para 19 - Wa Qalal Lazina",
            "Para 20 - A Man Khalaq",
            "Para 21 - Utlu Maa Oohiya",
            "Para 22 - Wa Man Yaqnut",
            "Para 23 - Wa Maa Liya",
            "Para 24 - Faman Azlam",
            "Para 25 - Elahe Yuruddo",
            "Para 26 - Haa Meem",
            "Para 27 - Qala Fama Khatbukum",
            "Para 28 - Qadd Sami Allah",
            "Para 29 - Tabarakal Lazi",
            "Para 30 - Amma Yatasa'aloon"
        )
    }

    val filteredList = remember(searchQuery) {
        if (searchQuery.isEmpty()) {
            paraList
        } else {
            paraList.filter {
                it.contains(searchQuery, ignoreCase = true) ||
                        it.substringBefore(" - ").contains(searchQuery, ignoreCase = true)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFB3A589))
            .padding(16.dp)
    ) {
        // App Title
        Text(
            text = "خلاصہ قرآن",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color(0xFF2D1810),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Khulasa Quran",
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = Color(0xFF5D4524),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Search Field
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search Para...") },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Search")
            },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(
                        onClick = {
                            searchQuery = ""
                            keyboardController?.hide()
                        }
                    ) {
                        Icon(Icons.Default.Clear, contentDescription = "Clear")
                    }
                }
            },
            shape = RoundedCornerShape(25.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFE0DEDC),
                focusedContainerColor = Color(0xFFE0DEDC),
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color(0xFF6650a4)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            singleLine = true
        )

        // Results count
        if (searchQuery.isNotEmpty()) {
            Text(
                text = "${filteredList.size} results found",
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF5D4524),
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        // Para List
        LazyColumn(
            state = listState,
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxSize()
                .animateContentSize()
        ) {
            items(filteredList, key = { it }) { paraName ->
                val paraNumber = paraName.substringBefore(" - ").removePrefix("Para ").toIntOrNull() ?: 1

                ElevatedCard(
                    onClick = {
                        val assetFileName = "para$paraNumber.pdf"
                        navController.navigate("para/$assetFileName")
                    },
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.elevatedCardColors(
                        containerColor = Color(0xFFC1B7A3)
                    ),
                    elevation = CardDefaults.elevatedCardElevation(
                        defaultElevation = 4.dp,
                        pressedElevation = 8.dp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Para Number Circle
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(
                                    Color(0xFF6650a4),
                                    RoundedCornerShape(20.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = paraNumber.toString(),
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        // Para Name
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Para $paraNumber",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                            if (paraName.contains(" - ")) {
                                Text(
                                    text = paraName.substringAfter(" - "),
                                    fontSize = 12.sp,
                                    color = Color(0xFF5D4524)
                                )
                            }
                        }
                    }
                }
            }

            // Add some bottom padding for the last item
            item {
                Spacer(modifier = Modifier.height(80.dp))
            }
        }

        // Show message when no results found
        if (filteredList.isEmpty() && searchQuery.isNotEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "No results found",
                        fontSize = 18.sp,
                        color = Color(0xFF5D4524)
                    )
                    Text(
                        text = "Try a different search term",
                        fontSize = 14.sp,
                        color = Color(0xFF8B7355)
                    )
                }
            }
        }
    }
}
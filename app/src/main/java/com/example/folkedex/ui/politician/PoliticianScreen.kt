package com.example.folkedex.ui.politician

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.folkedex.data.FavoritesHelper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PoliticianScreen(navController: NavController, name: String, onBackClick: () -> Unit = {}) {
    val context = LocalContext.current
    val favoritesHelper = remember { FavoritesHelper(context) }
    var isFavorite by remember { mutableStateOf(favoritesHelper.getFavorites().contains(name)) }


    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFF9C27B0), Color(0xFFE1BEE7))
                            )
                        )
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(top = 25.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        IconButton(
                            onClick = { navController.popBackStack() },
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .align(Alignment.CenterStart)
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }

                        IconButton(
                            onClick = {
                                if (isFavorite) {
                                    favoritesHelper.removeFavorite(name)
                                } else {
                                    favoritesHelper.addFavorite(name)
                                }
                                isFavorite = !isFavorite
                            },
                            modifier = Modifier
                                .padding(end = 16.dp)
                                .align(Alignment.CenterEnd)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                contentDescription = "Favorite",
                                tint = if (isFavorite) Color.Red else Color.White
                            )
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.align(Alignment.Center)
                        ) {
                            Text(
                                text = name,
                                fontSize = 20.sp,
                                color = Color.White,
                                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                            )
                        }
                    }
                }
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                PoliticianCard()

                Spacer(modifier = Modifier.height(0.dp))

                Box (
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.9f)
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFF9C27B0), Color(0xFFE1BEE7))
                            )
                        )
                        .padding(6.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "General Information",
                                fontSize = 24.sp,
                                color = Color.Black,
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(
                                text = """ Lars Løkke Rasmussen is a Danish politician. Since December 2022, Løkke has been Minister of Foreign Affairs in the government of Mette Frederiksen. Løkke has been both deputy chairman (1998 - 2009) and chairman (2009 - 2019) of the party Venstre until his resignation from the party in 2021. In the following year, Løkke officially founded the political party "Moderaterne".""".trimIndent(),
                                color = Color.White,
                                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 15.sp),
                                lineHeight = 20.sp, // Adds better line spacing
                                textAlign = TextAlign.Center
                            )
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "CV",
                                fontSize = 24.sp,
                                color = Color.Black,
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                            )

                            Spacer(modifier = Modifier.height(0.dp))

                            Text(
                                text = """
                                     - Minister of Foreign Affairs (2022 - )
                                     - Political Leader of Moderaterne (2022 - )
                                     - Prime Minister (2015 - 2019)
                                     - Prime Minister (2009 - 2011)
                                     - Chairman of Venstre (2009 - 2019)
                                     - Minister of Finance (2007 - 2009)
                                """.trimIndent(),
                                color = Color.White,
                                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp),
                                lineHeight = 20.sp, // Adds better line spacing
                                textAlign = TextAlign.Start
                            )
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPoliticianScreen() {
    PoliticianScreen(navController = NavController(LocalContext.current), name = "Lars Løkke Rasmussen")
}
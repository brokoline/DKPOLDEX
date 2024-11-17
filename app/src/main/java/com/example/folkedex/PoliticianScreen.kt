package com.example.folkedex

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.folkedex.PoliticianCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PoliticianScreen(navController: NavController, onBackClick: () -> Unit = {}) {
    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
            ) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp)
                        .background(Color.Gray.copy(alpha = 0.8f))
                )
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
                            .height(50.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        IconButton(
                            onClick = onBackClick,
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
                            onClick = {},
                            modifier = Modifier
                                .padding(end = 16.dp)
                                .align(Alignment.CenterEnd)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                contentDescription = "Favorite",
                                tint = Color.White
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.align(Alignment.Center)
                        ) {

                            Text(
                                "Lars Løkke Rasmussen",
                                fontSize = 20.sp,
                                color = Color.White,
                                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                            )
                        }
                    }
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp),
                containerColor = Color.Gray.copy(alpha = 0.8f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { /* Navigate to Home */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.home),
                            contentDescription = "Home",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = {/* Navigate to Favorites */}) {
                        Icon(
                            painter = painterResource(id = R.drawable.favorites),
                            contentDescription = "Home",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = {/* Navigate to settings */}) {
                        Icon(
                            painter = painterResource(id = R.drawable.settings),
                            contentDescription = "Settings",
                            tint = Color.White
                        )
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
                        // Top Section
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

                        Spacer(modifier = Modifier.height(14.dp)) // Space between sections

                        // Bottom Section
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
    PoliticianScreen(navController = NavController(LocalContext.current))
}
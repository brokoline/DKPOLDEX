package com.example.folkedex.ui.theme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.folkedex.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PoliticianProfileScreen() {
    val navController = rememberNavController()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE1BEE7)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Bar in the top of the page containing politician's name
        TopAppBar(
            title = {
                Text(
                    text = "Lars Løkke Rasmussen",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            },
            navigationIcon = {
                IconButton(onClick = {/* Handle action to go back */ }) {
                    Icon(
                        painter = painterResource(id = android.R.drawable.ic_media_previous),
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            },
            actions = {
                IconButton(onClick = { /* Handle pressing favorite */ }) {
                    Icon(
                        painter = painterResource(id = android.R.drawable.btn_star),
                        contentDescription = "Favorite",
                        tint = Color.White
                    )
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFFAB47BC))
        )

        // Image of politician
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.politician_image),
            contentDescription = "Politician image",
            modifier = Modifier
                .size(150.dp)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Text-section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFD1C4E9))
                .padding(16.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "ExampleText:",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = "Example",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text= " - ExampleText.\n - ExampleText.",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Paragraph (currently just exampleText)
        Text(
            text = "ExampleText, ExampleText, ExampleText, ExampleText, ExampleText, ExampleText, \n" +
            "ExampleText, ExampleText, ExampleText, ExampleText, ExampleText, ExampleText,",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier.padding(16.dp)
        )

        // Bottom navigation bar
        Spacer(modifier = Modifier.weight(1f))
        NavigationBar(
            containerColor = Color(0xFFAB47BC)
        ) {
            NavigationBarItem(
                selected = false,
                onClick = { /* handle navigation back to home-screen */ },
                icon = {
                    Icon(
                        painter = painterResource(id = android.R.drawable.ic_menu_view),
                        contentDescription = "Home",
                        tint = Color.White
                    )
                },
                label = {Text(text = "Home", color = Color.White)}
            )
            NavigationBarItem(
                selected = false,
                onClick = { /* Handle navigation to favorites-page */ },
                icon = {
                    Icon(
                        painter = painterResource(id = android.R.drawable.btn_star),
                        contentDescription = "Favorites",
                        tint = Color.White
                    )
                },
                label = { Text(text = "Favorites", color = Color.White)}
            )
            NavigationBarItem(
                selected = false,
                onClick = {  /* Handle navigation to news-page */ },
                icon = {
                    Icon(
                        painter = painterResource(id = android.R.drawable.ic_menu_info_details),
                        contentDescription = "News",
                        tint = Color.White
                    )
                },
                label = { Text(text = "News", color = Color.White)}
            )
            NavigationBarItem(
                selected = false,
                onClick = {  /* Handle navigation to settings-page */ },
                icon = {
                    Icon(
                        painter = painterResource(id = android.R.drawable.ic_menu_preferences),
                        contentDescription = "Settings",
                        tint = Color.White
                    )
                },
                label = { Text(text = "Settings", color = Color.White)}
            )
        }
    }
}


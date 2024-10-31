package com.example.folkedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.folkedex.ui.theme.FolkeDexTheme
import com.example.folkedex.ui.theme.FavoritesScreen
//import com.example.folkedex.PartyScreen
import com.example.folkedex.ui.theme.Party

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FolkeDexTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "main"
                ) {
                    composable("main") {
                        MainScreen(navController)
                    }
                    composable("favorites") {
                        FavoritesScreen(onBackClick = {
                            navController.navigate("main") {
                                popUpTo("main") { inclusive = true }
                            }
                        })
                    }
                    composable("Moderaterne") {
                        Party(onBackClick = {
                            navController.navigate("main") {
                                popUpTo("main") { inclusive = true }
                            }
                        })
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp), // Tilføj noget padding for layoutets skyld
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { navController.navigate("favorites") }
                ) {
                    Text(text = "Gå til Favoritter")
                }
                Button(
                    onClick = { navController.navigate("Moderaterne") }
                ) {
                    Text(text = "Moderaterne     ")
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    FolkeDexTheme {
        val navController = rememberNavController()
        MainScreen(navController)
    }
}

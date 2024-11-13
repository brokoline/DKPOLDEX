package com.example.folkedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.example.folkedex.ui.theme.Party
import com.example.folkedex.ui.theme.PartyRepository
import com.example.folkedex.ui.theme.FavoritesScreen
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.folkedex.ui.theme.History


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

                    composable("history") {
                        History(onBackClick = {
                            navController.navigate("main") {
                                popUpTo("main") { inclusive = true }
                            }
                        })
                    }
                    // getting list of parties from our "database" and creating routes for each
                    PartyRepository.parties.forEach { party ->
                        composable(party.name) {
                            val partyData = PartyRepository.getPartyByName(party.name)
                            if (partyData != null) {
                                Party(
                                    partyData = partyData,
                                    onBackClick = {
                                        navController.navigate("main") {
                                            popUpTo("main") { inclusive = true }
                                        }
                                    }, navController = navController
                                )
                            } else {
                                Text("Party data not found")
                            }
                        }
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Button to navigate to Favorites
                item {
                    Button(
                        onClick = { navController.navigate("favorites") },
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        Text(text = "Gå til Favoritter")
                    }
                }
                item {
                    Button(
                        onClick = { navController.navigate("history") },
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        Text(text = "Gå til historik")
                    }
                }

                //  create buttons for each party in PartyRepository/database
                items(PartyRepository.parties) { party ->
                    Button(
                        onClick = { navController.navigate(party.name) },
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        Text(text = party.name)
                    }
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

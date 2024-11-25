package com.example.folkedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// Import from Material 2 for BottomNavigation
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Scaffold
import com.example.folkedex.ui.theme.BillScreen
import com.example.folkedex.ui.theme.DataScreen
import com.example.folkedex.ui.theme.FavoritesScreen
import com.example.folkedex.ui.theme.History
import com.example.folkedex.ui.theme.NewsScreen
import com.example.folkedex.ui.theme.Party
import com.example.folkedex.ui.theme.PartyRepository
import com.example.folkedex.ui.theme.PartySelectionScreen
import com.example.folkedex.ui.theme.PoliciesScreen
import com.example.folkedex.ui.theme.IssuesScreen
import com.example.folkedex.ui.theme.PoliticianProfileScreen
import com.example.folkedex.ui.theme.ReportsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavHost()
        }
    }
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    MainScreen(navController)
}

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = { BottomTabBar(navController) }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home") { HomeScreen(navController) }
            composable("favorites") { FavoritesScreen(navController = navController) }
            composable("news") { NewsScreen(navController = navController) }
            composable("settings") { SettingsScreen(navController) }
            composable("folkedex") {PartySelectionScreen( navController = navController)}
            composable("issues") { IssuesScreen(navController = navController) }
            composable("politicians") { PoliticianProfileScreen(navController = navController) }
            composable("policies") { PoliciesScreen(navController = navController) }
            composable("reports") { ReportsScreen(navController = navController) }
            composable("bills") { BillScreen(navController = navController) }
            composable("history") { History(navController = navController) }
            composable("data") { DataScreen(navController = navController) }


            // Dynamically Add Party Routes
            PartyRepository.parties.forEach { party ->
                composable(party.path) {
                    val partyData = PartyRepository.getPartyByName(party.name)
                    if (partyData != null) {
                        Party(
                            partyData = partyData,
                            onBackClick = {
                                navController.navigate("home") {
                                    popUpTo("home") { inclusive = true }
                                }
                            },
                            navController = navController
                        )
                    } else {
                        Text("Party data not found")
                    }
                }


            }
        }
    }
}


@Composable
fun BottomTabBar(navController: NavHostController) {
    BottomNavigation(
        backgroundColor = Color.Gray
    ) {
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.White) },
            label = { Text("Home", color = Color.White) },
            selected = navController.currentDestination?.route == "home",
            onClick = { navController.navigate("home") { popUpTo("home") { inclusive = true } } }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites", tint = Color.White) },
            label = { Text("Favorites", color = Color.White) },
            selected = navController.currentDestination?.route == "favorites",
            onClick = { navController.navigate("favorites") { popUpTo("home") } }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Settings, contentDescription = "Settings", tint = Color.White) },
            label = { Text("Settings", color = Color.White) },
            selected = navController.currentDestination?.route == "settings",
            onClick = { navController.navigate("settings") { popUpTo("home") } }
        )
    }
}


@Composable
fun SettingsScreen(navController: NavHostController) {
    Text("Settings Screen Content Here")
}

package com.example.folkedex.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.folkedex.ui.common.HomeScreen
import com.example.folkedex.ui.politician.PoliciesScreen
import com.example.folkedex.ui.politician.PoliticianScreen
import com.example.folkedex.ui.theme.BillScreen
import com.example.folkedex.ui.theme.DataScreen
import com.example.folkedex.ui.theme.FavoritesScreen
import com.example.folkedex.ui.theme.History
import com.example.folkedex.ui.theme.NewsScreen
import com.example.folkedex.ui.theme.Party
import com.example.folkedex.ui.theme.PartyRepository
import com.example.folkedex.ui.theme.PartySelectionScreen
import com.example.folkedex.ui.theme.IssuesScreen
import com.example.folkedex.ui.theme.PoliticianSelectionScreen
import com.example.folkedex.ui.theme.ReportsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
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
        contentWindowInsets = WindowInsets(0.dp),
        bottomBar = { BottomTabBar(navController) }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home") { HomeScreen(navController) }
            composable("favorites") { FavoritesScreen(navController = navController) }
            composable("com/example/folkedex/ui/news") { NewsScreen(navController = navController) }
            composable("settings") { SettingsScreen(navController) }
            composable("folkedex") { PartySelectionScreen( navController = navController)}
            composable("com/example/folkedex/ui/issues") { IssuesScreen(navController = navController) }
            composable("politician/{name}") { backStackEntry ->
                val name = backStackEntry.arguments?.getString("name") ?: "Unknown"
                PoliticianScreen(navController = navController, name = name)
            }

            composable("policies") { PoliciesScreen(navController = navController) }
            composable("reports") { ReportsScreen(navController = navController) }
            composable("bills") { BillScreen(navController = navController) }
            composable("com/example/folkedex/ui/history") { History(navController = navController) }
            composable("com/example/folkedex/data") { DataScreen(navController = navController) }
            composable("politicians") { PoliticianSelectionScreen(navController = navController) }



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
    NavigationBar(
        containerColor = Color.Gray
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home", modifier = Modifier.size(35.dp), tint = Color.White) },
            label = { Text("Home", fontSize = 20.sp, color = Color.White) },
            selected = navController.currentDestination?.route == "home",
            onClick = { navController.navigate("home") { popUpTo("home") { inclusive = true } } }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites", modifier = Modifier.size(35.dp), tint = Color.White) },
            label = { Text("Favorites", fontSize = 20.sp, color = Color.White) },
            selected = navController.currentDestination?.route == "favorites",
            onClick = { navController.navigate("favorites") { popUpTo("home") } }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Settings, contentDescription = "Settings", modifier = Modifier.size(35.dp), tint = Color.White) },
            label = { Text("Settings", fontSize = 20.sp, color = Color.White) },
            selected = navController.currentDestination?.route == "settings",
            onClick = { navController.navigate("settings") { popUpTo("home") } }
        )
    }
}

@Composable
fun SettingsScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("--TO-BE-IMPLEMENTED--\n ----FUTURE FEATURE---")
    }
}


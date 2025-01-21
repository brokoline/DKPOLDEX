package com.example.folkedex.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.folkedex.ui.common.HomeScreen
import com.example.folkedex.ui.history.HistoryScreen
import com.example.folkedex.ui.politician.PoliciesScreen
import com.example.folkedex.ui.politician.PoliticianScreen
import com.example.folkedex.ui.bill.BillScreen
import com.example.folkedex.ui.theme.DataScreen
import com.example.folkedex.ui.theme.FavoritesScreen
import com.example.folkedex.ui.news.NewsScreen
import com.example.folkedex.ui.party.Party
import androidx.compose.ui.platform.LocalContext


import com.example.folkedex.ui.party.PartySelectionScreen
import com.example.folkedex.data.PartyRepository
import com.example.folkedex.data.local.DataStore
import com.example.folkedex.ui.feature.PartyViewModel
import com.example.folkedex.ui.feature.PartyViewModelFactory
import com.example.folkedex.ui.theme.IssuesScreen
import com.example.folkedex.ui.politician.PoliticianSelectionScreen
import com.example.folkedex.ui.report.ReportsScreen
import kotlinx.coroutines.delay
import androidx.compose.foundation.layout.Arrangement
import com.example.folkedex.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            val dataStore = DataStore(context)
            val viewModel: PartyViewModel = viewModel(factory = PartyViewModelFactory(dataStore))


            val parties by viewModel.parties.collectAsState()
            val politician = parties
                .flatMap { it.politicians }
         //   Log.d("api content test", politician.toString())
            LaunchedEffect(Unit) {
                viewModel.fetchAndCachePartyData()



            }
            LaunchedEffect(politician.isEmpty()) {
                delay(5000) // Wait for 5 seconds

            }
            if (politician.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CircularProgressIndicator() // Display the loading indicator
                            Spacer(modifier = Modifier.height(16.dp)) // Add space between the indicator and text
                            Text("Loading Politicians") // Display the text below the indicator
                        }
                        Spacer(modifier = Modifier.width(16.dp)) // Add space between the column and the image
                        Image(
                            painter = painterResource(id = R.drawable.loading), // Replace with your image resource
                            contentDescription = "Loading Icon",
                            modifier = Modifier.size(100.dp) // Adjust size as needed
                        )
                    }
                }

            } else {
                // Show the main content
                AppNavHost()
            }

            //AppNavHost()
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
            composable("home") {
                HomeScreen(navController = navController) // No context needed
            }
            composable("favorites") { FavoritesScreen(navController = navController) }
            composable("com/example/folkedex/ui/news") { NewsScreen(navController = navController) }
            composable("settings") { com.example.folkedex.ui.settings.SettingsScreen(navController) }
            composable("folkedex") { PartySelectionScreen(navController = navController) }
            composable("com/example/folkedex/ui/issues") { IssuesScreen(navController = navController) }
            composable("politician/{name}") { backStackEntry ->
                val name = backStackEntry.arguments?.getString("name") ?: "Unknown"
                PoliticianScreen(navController = navController, name = name)
            }
            composable("policies/{partyName}") { backStackEntry ->
                val partyName = backStackEntry.arguments?.getString("partyName") ?: "Unknown"
                val partyData = PartyRepository.getPartyByName(partyName)

                if (partyData != null) {
                    PoliciesScreen(navController = navController, partyData = partyData)
                } else {
                    Text(text = "Party data not found", color = Color.Red, modifier = Modifier.fillMaxSize())
                }
            }
            composable("reports") { ReportsScreen() }
            composable("bills") { BillScreen(navController = navController) }
            composable("com/example/folkedex/ui/history/{partyPath}") { backStackEntry ->
                val partyPath = backStackEntry.arguments?.getString("partyPath")
                val partyData = PartyRepository.getPartyByName(partyPath ?: "")
                if (partyData != null) {
                    HistoryScreen(navController = navController, partyData = partyData)
                } else {
                    Text("No history available")
                }
            }
            composable("com/example/folkedex/data") { DataScreen(navController = navController) }
            composable("politicians/{partyName}") { backStackEntry ->
                val partyName = backStackEntry.arguments?.getString("partyName") ?: "Unknown"
                PoliticianSelectionScreen(navController = navController, partyName = partyName)
            }

            PartyRepository.parties.forEach { party ->
                composable(party.path) {
                    val partyData = PartyRepository.getPartyByName(party.name)
                    if (partyData != null) {
                        Party(
                            partyData = partyData,
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
fun IndeterminateCircularIndicator(isLoading: Boolean) {

if(isLoading){
    CircularProgressIndicator(
        modifier = Modifier.width(64.dp),
        color = Color.Gray,
        trackColor = Color.White
    )
   // Log.d("inside the loading screen", isLoading.toString())
}

}
@Composable
fun BottomTabBar(navController: NavHostController) {
    NavigationBar(
        containerColor = Color.White
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home", /*modifier = Modifier.padding(top = 10.dp),*/ tint = Color.Gray) },
            label = { Text("Home", /*fontSize = 20.sp,*/ color = Color.Gray) },
            selected = navController.currentDestination?.route == "home",
            onClick = { navController.navigate("home") { popUpTo("home") { inclusive = true } } }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites", /*modifier = Modifier.padding(top = 10.dp),*/ tint = Color.Gray) },
            label = { Text("Favorites", /*fontSize = 20.sp,*/ color = Color.Gray) },
            selected = navController.currentDestination?.route == "favorites",
            onClick = { navController.navigate("favorites") { popUpTo("home") } }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Settings, contentDescription = "Settings", /*modifier = Modifier.padding(top = 10.dp),*/ tint = Color.Gray) },
            label = { Text("Settings", /*fontSize = 20.sp,*/ color = Color.Gray) },
            selected = navController.currentDestination?.route == "settings",
            onClick = { navController.navigate("settings") { popUpTo("home") } }
        )
    }
}


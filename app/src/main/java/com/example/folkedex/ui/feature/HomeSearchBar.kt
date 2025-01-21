package com.example.folkedex.ui.components

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.folkedex.data.PartyRepository.parties
import com.example.folkedex.data.local.DataStore
import com.example.folkedex.data.model.Actor
import com.example.folkedex.model.PartyData
import kotlinx.coroutines.runBlocking


@Composable
fun HomeSearchBar(
    context: Context,
    navController: NavController,
    modifier: Modifier = Modifier,
    onSuggestionClick: (Actor?) -> Unit = {},
    OnSuggestionClick: (PartyData?) -> Unit = {}
) {
    var query by remember { mutableStateOf(TextFieldValue("")) }
    var suggestions by remember { mutableStateOf(listOf<String>()) }
    val dataStore = remember { DataStore(context) }

    LaunchedEffect(Unit) {
        val actors = dataStore.loadActors()

        suggestions = listOf("Home", "Favorites", "Reports", "News") +
                actors.map { it.navn } + parties.map { it.name }
    }

    val filteredSuggestions = suggestions.filter { it.contains(query.text, ignoreCase = true) }

    Column(modifier = modifier) {
        TextField(
            value = query,
            onValueChange = { newQuery -> query = newQuery },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            },
            placeholder = {
                Text(text = "Search for Politician, Party, etc...")
            },
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFF5F5F5),
                unfocusedContainerColor = Color(0xFFF5F5F5),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                cursorColor = Color.Black
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(vertical = 4.dp)
        )

        if (query.text.isNotEmpty() && filteredSuggestions.isNotEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(vertical = 4.dp)
            ) {
                filteredSuggestions.forEach { suggestion ->
                    Text(
                        text = suggestion,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                query = TextFieldValue(suggestion)
                                onSuggestionClick(getActorFromName(suggestion, dataStore))
                                OnSuggestionClick(getPartyFromName(suggestion, dataStore))
                                navigateToRoute(suggestion, navController)
                            }
                            .padding(8.dp),
                        color = Color.Black
                    )
                }
            }
        }
    }
}

fun getActorFromName(name: String, dataStore: DataStore): Actor? {
    val actors = runBlocking { dataStore.loadActors() }
    return actors.find { it.navn.equals(name, ignoreCase = true) }
}
fun getPartyFromName(name: String, dataStore: DataStore): PartyData? {
    val parties = runBlocking { dataStore.loadParties() }
    return parties.find { it.name.equals(name, ignoreCase = true) }
}

fun navigateToRoute(suggestion: String, navController: NavController) {
    val party = parties.find { it.name.equals(suggestion, ignoreCase = true) }
    when {
        suggestion == "Home" -> navController.navigate("home")
        suggestion == "Favorites" -> navController.navigate("favorites")
        suggestion == "Reports" -> navController.navigate("reports")
        suggestion == "Issues" -> navController.navigate("issues")
        suggestion == "News" -> navController.navigate("news")
        party != null -> {
            navController.navigate(party.path)
        }
        else -> {
            navController.navigate("politician/$suggestion")
        }
    }
}
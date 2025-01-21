package com.example.folkedex.ui.components

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.folkedex.data.local.DataStore
import com.example.folkedex.data.model.Actor
import kotlinx.coroutines.runBlocking


@Composable
fun HomeSearchBar(
    context: Context,
    navController: NavController,
    modifier: Modifier = Modifier,
    onSuggestionClick: (Actor?) -> Unit = {}
) {
    var query by remember { mutableStateOf(TextFieldValue("")) }
    var suggestions by remember { mutableStateOf(listOf<String>()) }
    val dataStore = remember { DataStore(context) }

    LaunchedEffect(Unit) {
        val actors = dataStore.loadActors()
        suggestions = listOf("Home", "Favorites", "Reports", "Issues", "News") +
                actors.map { it.navn }
    }

    val filteredSuggestions = suggestions.filter { it.contains(query.text, ignoreCase = true) }

    Column(modifier = modifier) {
        BasicTextField(
            value = query,
            onValueChange = { newQuery ->
                query = newQuery
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.White, shape = MaterialTheme.shapes.small)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            singleLine = true
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

fun navigateToRoute(suggestion: String, navController: NavController) {
    when (suggestion) {
        "Home" -> navController.navigate("home")
        "Favorites" -> navController.navigate("favorites")
        "Reports" -> navController.navigate("reports")
        "Issues" -> navController.navigate("issues")
        "News" -> navController.navigate("news")
        else -> {
            navController.navigate("politician/$suggestion")
        }
    }
}
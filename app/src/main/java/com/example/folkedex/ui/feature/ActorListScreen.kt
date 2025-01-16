package com.example.folkedex.ui.feature


//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.folkedex.domain.ActorItem
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.navigation.NavController

@Composable
fun ActorListScreen(viewModel: ActorViewModel = viewModel(), navController: NavController) {
    val actors by viewModel.actors.collectAsState()

    if (actors.isEmpty()) {
        Text("No actors to display", modifier = Modifier.padding(16.dp))
    } else {
        LazyColumn {
            items(actors) { actor ->
                ActorItem(actor)
            }
        }
    }
}
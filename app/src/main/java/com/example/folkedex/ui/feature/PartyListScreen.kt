package com.example.folkedex.ui.feature

import android.content.Context
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
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.folkedex.data.local.DataStore
import com.example.folkedex.model.PartyData

/*@Composable
fun PartyListScreen(viewModel: PartyViewModel = viewModel(factory = PartyViewModelFactory(LocalContext.current)), navController: NavController) {
    val parties by viewModel.parties.collectAsState()

    LazyColumn {
        items(parties) { party ->
            PartyItem(party)
        }
    }
}
*/
@Composable
fun PartyItem(party: PartyData) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = party.name, style = MaterialTheme.typography.h6)


        if (party.politicians.isNotEmpty()) {
            Text(text = "Politicians:")
            party.politicians.forEach { actor ->
                Text(text = "- ${actor.navn}")
            }
        } else {
            Text(text = "No politicians available.")
        }
    }
}
class PartyViewModelFactory(private val dataStore: DataStore) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PartyViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PartyViewModel(dataStore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
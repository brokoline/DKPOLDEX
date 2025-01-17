package com.example.folkedex.ui.feature


//noinspection UsingMaterialAndMaterial3Libraries
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
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Composable
fun ActorListScreen(viewModel: ActorViewModel = viewModel(factory = ActorViewModelFactory(LocalContext.current)), navController: NavController) {
    val actors by viewModel.actors.collectAsState()

    if (actors.isEmpty()) {
        Text("No actors to display")
    } else {
        LazyColumn {
            items(actors) { actor ->
                ActorItem(actor)
            }
        }
    }
}
class ActorViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ActorViewModel(context) as T
    }
}
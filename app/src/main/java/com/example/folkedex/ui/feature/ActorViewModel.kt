package com.example.folkedex.ui.feature

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.folkedex.data.model.Actor
import com.example.folkedex.ui.feature.FetchActors.fetchActors
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ActorViewModel(private  val context: Context) : ViewModel() {
    private val mutableActorsUIState = MutableStateFlow<List<Actor>>(emptyList())
    val actors: StateFlow<List<Actor>> = mutableActorsUIState

    init {
        fetchActorsFromApi()
    }

    private fun fetchActorsFromApi() {
        viewModelScope.launch {
            val allActors = fetchActors(context)
            mutableActorsUIState.value = allActors
        }
    }
}
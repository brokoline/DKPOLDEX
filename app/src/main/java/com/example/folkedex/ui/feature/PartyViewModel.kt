package com.example.folkedex.ui.feature

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.folkedex.data.PartyRepository
import com.example.folkedex.data.PartyRepository.mapActorsToParties
import com.example.folkedex.data.local.DataStore

import com.example.folkedex.model.PartyData
import com.example.folkedex.ui.feature.FetchActors.fetchActors
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PartyViewModel(private val context: Context) : ViewModel() {
    private val _parties = MutableStateFlow<List<PartyData>>(emptyList())
    val parties: StateFlow<List<PartyData>> = _parties

    private val dataStore = DataStore(context)

    init {
        loadCachedParties()
    }

    // Load cached parties on initialization
    private fun loadCachedParties() {
        viewModelScope.launch {
            try {
                val cachedActors = dataStore.loadActors()
                if (cachedActors.isNotEmpty()) {
                    val updatedParties = mapActorsToParties(cachedActors, PartyRepository.parties)
                    _parties.value = updatedParties
                } else {
                    fetchPartiesWithPoliticians()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                fetchPartiesWithPoliticians() // Fallback to fetching data if cache fails
            }
        }
    }

    // Fetch parties and save data to cache
    private fun fetchPartiesWithPoliticians() {
        viewModelScope.launch {
            try {
                val actors = fetchActors(context)
                val updatedParties = mapActorsToParties(actors, PartyRepository.parties)
                _parties.value = updatedParties

                // Save actors to cache
                dataStore.saveActors(actors)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    // Explicitly fetch and cache data (can be triggered manually)
    fun fetchAndCachePartyData() {
        viewModelScope.launch {
            try {
                val actors = fetchActors(context)
                val updatedParties = mapActorsToParties(actors, PartyRepository.parties)
                _parties.value = updatedParties

                // Save actors to cache
                dataStore.saveActors(actors)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

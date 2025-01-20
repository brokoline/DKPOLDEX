package com.example.folkedex.ui.feature

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

class PartyViewModel(private val dataStore: DataStore) : ViewModel() {
    private val _parties = MutableStateFlow<List<PartyData>>(emptyList())
    val parties: StateFlow<List<PartyData>> = _parties
    private val _isLoading = MutableStateFlow(false) // Loading state
    val isLoading: StateFlow<Boolean> = _isLoading
    init {
        loadCachedParties()
    }

    // Load cached parties on initialization
    private fun loadCachedParties() {
        viewModelScope.launch {
            _isLoading.value = true
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
            } finally {
                _isLoading.value = false
            }
        }
    }

    // Fetch parties and save data to cache
    private fun fetchPartiesWithPoliticians() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val actors = fetchActors(dataStore)
                val updatedParties = mapActorsToParties(actors, PartyRepository.parties)
                _parties.value = updatedParties

                // Save actors to cache
                dataStore.saveActors(actors)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }

    // Explicitly fetch and cache data (can be triggered manually)
    fun fetchAndCachePartyData() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val actors = fetchActors(dataStore)
                val updatedParties = mapActorsToParties(actors, PartyRepository.parties)
                _parties.value = updatedParties

                // Save actors to cache
                dataStore.saveActors(actors)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
    fun emptyCache(){
        viewModelScope.launch{
            _parties.value=emptyList()

        }
    }

}

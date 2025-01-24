package com.example.folkedex.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.folkedex.data.local.PartyRepository
import com.example.folkedex.data.local.PartyRepository.mapActorsToParties
import com.example.folkedex.data.local.DataStore

import com.example.folkedex.data.model.PartyData
import com.example.folkedex.data.remote.FetchActors.fetchActors
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainActivityViewModel(private val dataStore: DataStore) : ViewModel() {
    private val _parties = MutableStateFlow<List<PartyData>>(emptyList())
    val parties: StateFlow<List<PartyData>> = _parties
    private val _isLoading = MutableStateFlow(false)

    init {
        loadCachedParties()
    }

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
                fetchPartiesWithPoliticians()
            } finally {
                _isLoading.value = false
            }
        }
    }

    private fun fetchPartiesWithPoliticians() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val actors = fetchActors(dataStore)
                val updatedParties = mapActorsToParties(actors, PartyRepository.parties)
                _parties.value = updatedParties
                dataStore.saveActors(actors)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun fetchAndCachePartyData() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val actors = fetchActors(dataStore)
                val updatedParties = mapActorsToParties(actors, PartyRepository.parties)
                _parties.value = updatedParties

                dataStore.saveActors(actors)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}
class MainActivityViewModelFactory(private val dataStore: DataStore) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainActivityViewModel(dataStore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
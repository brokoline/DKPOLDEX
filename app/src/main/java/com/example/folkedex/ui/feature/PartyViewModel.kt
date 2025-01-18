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

    init {
        fetchPartiesWithPoliticians()
    }

    private fun fetchPartiesWithPoliticians() {
        viewModelScope.launch {

            val actors = fetchActors(context)
           // Log.d("PartyViewModel", "Fetched ${actors.size} politicians from the API.")

            val updatedParties = mapActorsToParties(actors, PartyRepository.parties)
            //Log.d("PartyViewModel", updatedParties.get(0).politicians.toString())

            _parties.value = updatedParties
        }
    }
    fun fetchAndCachePartyData(context: Context) {
        viewModelScope.launch {
            try {
                val actors = fetchActors(context)
                val updatedParties = mapActorsToParties(actors, PartyRepository.parties)
                PartyRepository.cachedParties = updatedParties
                DataStore(context).saveActors(actors)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}


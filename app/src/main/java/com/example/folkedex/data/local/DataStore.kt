package com.example.folkedex.data.local

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.folkedex.data.model.Actor
import com.example.folkedex.model.PartyData
import kotlinx.coroutines.flow.first
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private val Context.dataStore by preferencesDataStore(name = "folkedex_datastore")

class DataStore(context: Context) {

    private val datastore = context.dataStore

    // Keys for storing data
    private val ACTORS_KEY = stringPreferencesKey("actors_data")
    private val PARTIES_KEY = stringPreferencesKey("parties_data")

    /**
     * Saves the list of actors to DataStore.
     */
    suspend fun saveActors(actors: List<Actor>) {
        val jsonString = Json.encodeToString(actors)
        datastore.edit { preferences ->
            preferences[ACTORS_KEY] = jsonString
        }
    }

    /**
     * Loads the list of actors from DataStore.
     */
    suspend fun loadActors(): List<Actor> {
        val preferences = datastore.data.first()
        val jsonString = preferences[ACTORS_KEY] ?: return emptyList()
        return try {
            Json.decodeFromString(jsonString)
        } catch (e: Exception) {
            emptyList()
        }
    }

    /**
     * Saves the list of parties to DataStore.
     */
    suspend fun saveParties(parties: List<PartyData>) {
        val jsonString = Json.encodeToString(parties)
        datastore.edit { preferences ->
            preferences[PARTIES_KEY] = jsonString
        }
    }

    /**
     * Loads the list of parties from DataStore.
     */
    suspend fun loadParties(): List<PartyData> {
        val preferences = datastore.data.first()
        val jsonString = preferences[PARTIES_KEY] ?: return emptyList()
        return try {
            Json.decodeFromString(jsonString)
        } catch (e: Exception) {
            emptyList()
        }
    }
}

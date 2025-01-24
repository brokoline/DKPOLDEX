package com.example.folkedex.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.folkedex.data.model.Actor
import com.example.folkedex.data.model.FileData
import com.example.folkedex.data.model.PartyData
import kotlinx.coroutines.flow.first
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private val Context.dataStore by preferencesDataStore(name = "folkedex_datastore")

class DataStore(context: Context) {

    private val datastore = context.dataStore

    private val ACTORS_KEY = stringPreferencesKey("actors_data")
    private val PARTIES_KEY = stringPreferencesKey("parties_data")
    private val FILES_KEY = stringPreferencesKey("files_data")


    suspend fun saveActors(actors: List<Actor>) {
        val jsonString = Json.encodeToString(actors)
        datastore.edit { preferences ->
            preferences[ACTORS_KEY] = jsonString
        }
    }

    suspend fun loadActors(): List<Actor> {
        val preferences = datastore.data.first()
        val jsonString = preferences[ACTORS_KEY] ?: return emptyList()
        return try {
            Json.decodeFromString(jsonString)
        } catch (e: Exception) {
            emptyList()
        }
    }


    suspend fun loadParties(): List<PartyData> {
        val preferences = datastore.data.first()
        val jsonString = preferences[PARTIES_KEY] ?: return emptyList()
        return try {
            Json.decodeFromString(jsonString)
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun saveFiles(files: List<FileData>) {
        val jsonString = Json.encodeToString(files)
        datastore.edit { preferences ->
            preferences[FILES_KEY] = jsonString
        }
    }

    suspend fun loadFiles(): List<FileData> {
        val preferences = datastore.data.first()
        val jsonString = preferences[FILES_KEY] ?: return emptyList()
        return try {
            Json.decodeFromString(jsonString)
        } catch (e: Exception) {
            emptyList()
        }
    }
}

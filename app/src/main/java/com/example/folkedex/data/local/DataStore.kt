package com.example.folkedex.data.local
import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.folkedex.data.model.Actor
import kotlinx.coroutines.flow.first
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
private val Context.dataStore by preferencesDataStore(name = "actors_datastore")
class DataStore(private val context: Context) {
    private enum class ActorKey(val key: String) {
        ACTOR_DATA("actors_data")
    }
    private val ACTORS_KEY = stringPreferencesKey(ActorKey.ACTOR_DATA.key)


    suspend fun saveActors(actors: List<Actor>) {
        val jsonString = Json.encodeToString(actors)
        context.dataStore.edit { preferences ->
            preferences[ACTORS_KEY] = jsonString
        }
    }


    suspend fun loadActors(): List<Actor> {
        val preferences = context.dataStore.data.first()
        val jsonString = preferences[ACTORS_KEY] ?: return emptyList()
        return try {
            Json.decodeFromString(jsonString)
        } catch (e: Exception) {
            emptyList()
        }
    }
}
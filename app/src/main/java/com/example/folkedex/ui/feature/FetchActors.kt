package com.example.folkedex.ui.feature
import android.content.Context
import com.example.folkedex.data.model.Actor
import com.example.folkedex.data.local.DataStore
import com.example.folkedex.data.remote.RetrofitInstance

object FetchActors {


    suspend fun fetchActors(dataStore: DataStore): List<Actor> {
        val allActors = mutableListOf<Actor>()
        var skip = 0
        val pageSize = 100

        return try {
            while (true) {
                val response = RetrofitInstance.api.getActors(skip)
                val actorsBatch = response.actors

                if (actorsBatch.isEmpty()) break

                allActors.addAll(actorsBatch)
                skip += pageSize
            }

            dataStore.saveActors(allActors)
            allActors
        } catch (e: Exception) {
            e.printStackTrace()

            dataStore.loadActors()
        }
    }

}


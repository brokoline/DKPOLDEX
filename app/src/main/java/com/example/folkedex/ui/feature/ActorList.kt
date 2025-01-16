package com.example.folkedex.ui.feature
import com.example.folkedex.data.model.Actor
import android.util.Log
import com.example.folkedex.data.remote.RetrofitInstance

object FetchActors {



    suspend fun fetchAllActors(): List<Actor> {
        val allActors = mutableListOf<Actor>()
        var skip = 0
        val pageSize = 100

        try {
            while (true) {
                val response = RetrofitInstance.api.getActors(skip)
                val actorsBatch = response.actors


                if (actorsBatch.isEmpty()) {
                    break
                }

                allActors.addAll(actorsBatch)
                skip += pageSize

                Log.d("FetchActors", "Loaded ${allActors.size} actors so far...")
            }
        } catch (e: Exception) {
            Log.e("FetchActors", "Error fetching actors: ${e.localizedMessage}")
        }

        return allActors
    }


}
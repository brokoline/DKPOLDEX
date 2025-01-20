package com.example.folkedex.data

import android.content.Context
import android.content.SharedPreferences

class FavoritesHelper(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("Favorites", Context.MODE_PRIVATE)

    fun addFavorite(politicianName: String) {
        val favorites = getFavorites().toMutableSet()
        favorites.add(politicianName)
        sharedPreferences.edit().putStringSet("favorites", favorites).apply()
    }

    fun removeFavorite(politicianName: String) {
        val favorites = getFavorites().toMutableSet()
        favorites.remove(politicianName)
        sharedPreferences.edit().putStringSet("favorites", favorites).apply()
    }

    fun getFavorites(): Set<String> {
        return sharedPreferences.getStringSet("favorites", emptySet()) ?: emptySet()
    }

    fun clearFavorites() {
        sharedPreferences.edit().remove("favorites").apply()
    }


    fun getFavoritesAsString(): String {
        val favorites = getFavorites()
        return if (favorites.isEmpty()) {
            "No favorites found."
        } else {
            favorites.joinToString(separator = "\n") { "- $it" }
        }
    }
}

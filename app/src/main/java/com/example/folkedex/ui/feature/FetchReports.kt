package com.example.folkedex.ui.feature



import android.util.Log
import com.example.folkedex.data.local.DataStore
import com.example.folkedex.data.remote.FileData
import com.example.folkedex.data.remote.RetrofitInstance

object FetchReports {
    suspend fun fetchReports(dataStore: DataStore, skip: Int = 0, pageSize: Int = 10): List<FileData> {
        return try {
            val response = RetrofitInstance.api.getFiles(skip)
            val reportsBatch = response.value

            // Save fetched data to DataStore if needed
            if (reportsBatch.isNotEmpty()) {
                val allReports = dataStore.loadFiles().toMutableList()
                allReports.addAll(reportsBatch)
                dataStore.saveFiles(allReports)
            }

            reportsBatch
        } catch (e: Exception) {
            e.printStackTrace()
            // Fallback to locally cached data in case of error
            emptyList()
        }
    }
}


package com.example.folkedex.data.remote



import com.example.folkedex.data.local.DataStore
import com.example.folkedex.data.model.FileData

object FetchReports {
    suspend fun fetchReports(dataStore: DataStore, skip: Int = 0): List<FileData> {
        return try {
            val response = RetrofitInstance.api.getFiles(skip)
            val reportsBatch = response.value


            if (reportsBatch.isNotEmpty()) {
                val allReports = dataStore.loadFiles().toMutableList()
                allReports.addAll(reportsBatch)
                dataStore.saveFiles(allReports)
            }

            reportsBatch
        } catch (e: Exception) {
            e.printStackTrace()

            emptyList()
        }
    }
}


package com.example.folkedex.ui.report
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.folkedex.data.local.DataStore
import com.example.folkedex.data.model.FileData
import com.example.folkedex.data.remote.FetchReports
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ReportsViewModel(private val dataStore: DataStore) : ViewModel() {
    private val _files = MutableStateFlow<List<FileData>>(emptyList())
    val files = _files.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()
    private var currentPage = 0 // Tracks the current page index
    private val pageSize = 10 // Number of files per page
    private var isLastPage = false // Tracks if the last page has been reached

    init {
        loadNextPage()
        Log.d("loading reports", files.value.toString())
    }
    init {
        viewModelScope.launch {
            isLoading.collect { value ->
                Log.d("ReportsViewModel", "isLoading updated: $value")
            }
        }
    }

    fun loadNextPage() {
        Log.d("ReportsViewModel", "Attempting to load next page... isLoading=${_isLoading.value}, isLastPage=$isLastPage")
        if (_isLoading.value || isLastPage) {
            Log.d("ReportsViewModel", "Skipping load: isLoading=${_isLoading.value}, isLastPage=$isLastPage")
            return
        }

        _isLoading.value = true
        Log.d("ReportsViewModel", "Loading next page: currentPage=$currentPage")

        viewModelScope.launch {
            try {
                val response = FetchReports.fetchReports(dataStore, currentPage * pageSize, pageSize)
                Log.d("ReportsViewModel", "Fetched ${response.size} files")
                if (response.isEmpty()) {
                    isLastPage = true
                    Log.d("ReportsViewModel", "No more pages to load")
                } else {
                    _files.value = _files.value + response
                    currentPage++
                    Log.d("ReportsViewModel", "New total reports: ${_files.value.size}")
                }
            } catch (e: Exception) {
                Log.e("ReportsViewModel", "Error while fetching reports: ${e.message}")
            } finally {
                _isLoading.value = false
                Log.d("ReportsViewModel", "Finished loading page")
            }
        }

    }



}

class ReportsViewModelFactory(private val dataStore: DataStore) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReportsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ReportsViewModel(dataStore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
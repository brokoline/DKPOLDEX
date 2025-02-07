package com.example.folkedex.ui.report

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshotFlow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.folkedex.data.model.FileData
import com.example.folkedex.data.local.DataStore
import androidx.compose.foundation.lazy.rememberLazyListState
import android.net.Uri
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.folkedex.ui.common.FolketingLogo
import com.example.folkedex.ui.feature.AltSearchBar

@Composable
fun ReportsScreen(navController: NavController) {
    val context = LocalContext.current
    val dataStore = DataStore(context)
    val viewModel: ReportsViewModel = viewModel(factory = ReportsViewModelFactory(dataStore))
    val reports = viewModel.files.collectAsState().value
    val isLoading = viewModel.isLoading.collectAsState().value
    var searchQuery by remember { mutableStateOf("") }

    val listState = rememberLazyListState()

    val filteredReports = if (searchQuery.isBlank()) {
        reports
    } else {
        reports.filter { it.titel.contains(searchQuery, ignoreCase = true) }
    }

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .background(Color(0xFFAED581)),
                contentAlignment = Alignment.CenterStart
            ) {
                FolketingLogo(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset(x = -50.dp)
                        .offset(y = -25.dp)
                        .size(205.dp)
                        .zIndex(0f)
                )
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Reports Icon",
                        tint = Color.White,
                        modifier = Modifier
                            .size(100.dp)
                            .padding(bottom = 4.dp)
                    )
                    Text(
                        "Reports",
                        fontSize = 30.sp,
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )

                    AltSearchBar(
                        value = searchQuery,
                        onValueChange = { newText -> searchQuery = newText },
                        onFocusChanged = {},
                        placeholderText = "Search for a topic of interest...",
                        modifier = Modifier
                            .padding(horizontal = 15.dp)
                    )
                }
            }
        },
        content = { paddingValues ->
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
                    .padding(
                        start = 46.dp,
                        end = 46.dp,
                        top = paddingValues.calculateTopPadding()
                    ),
                contentPadding = PaddingValues(
                    top = 16.dp,
                    bottom = 16.dp
                )
            ) {
                items(filteredReports) { report ->
                    ReportCard(
                        report = report,
                        onClick = { report.fileUrl?.let { url ->
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                            context.startActivity(intent)
                        }}
                    )
                }
                if (isLoading) {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }
            }
        }
    )

    LaunchedEffect(listState) {
        snapshotFlow {
            val layoutInfo = listState.layoutInfo
            val totalItemsCount = layoutInfo.totalItemsCount
            val lastVisibleItemIndex = layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0
            totalItemsCount to lastVisibleItemIndex
        }.collect { (totalItemsCount, lastVisibleItemIndex) ->
            if (lastVisibleItemIndex >= totalItemsCount - (if (isLoading) 2 else 1)) {
                viewModel.loadNextPage()
            }
        }
    }
}

@Composable
fun ReportCard(report: FileData, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(16.dp))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFFAED581),
                        Color(0xFFD4F5A7)
                    )
                ),
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = report.titel,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = report.fileUrl,
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.8f),
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}
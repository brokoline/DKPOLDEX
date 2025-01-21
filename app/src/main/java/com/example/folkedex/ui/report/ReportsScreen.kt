package com.example.folkedex.ui.report

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info // Importer et andet ikon, hvis det er passende
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import androidx.datastore.dataStore
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.folkedex.data.remote.ApiService
import com.example.folkedex.data.remote.FileData
import com.example.folkedex.ui.common.FolketingLogo
import com.example.folkedex.ui.feature.PartyViewModel
import com.example.folkedex.ui.feature.PartyViewModelFactory
import com.example.folkedex.data.local.DataStore
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.remember
import android.net.Uri

@Composable
fun ReportsScreen(
    onReportClick: (String) -> Unit = {},
    navController: NavController,
) {
    val context = LocalContext.current
    val dataStore = DataStore(context)
    val viewModel: ReportsViewModel = viewModel(factory = ReportsViewModelFactory(dataStore))
    val reports = viewModel.files.collectAsState().value
    val isLoading = viewModel.isLoading.collectAsState().value


    val listState = rememberLazyListState()

    Scaffold(
        topBar = {

        },
        content = { paddingValues ->
            LazyColumn(
                state = listState, // Attach the LazyListState
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                items(reports) { report ->
                    ReportCard(
                        report = report,
                        onClick = { report.fileUrl?.let { url ->
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                            context.startActivity(intent) }}
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

    // Detect when the user scrolls to the bottom
    LaunchedEffect(listState) {
        snapshotFlow {
            val layoutInfo = listState.layoutInfo
            val totalItemsCount = layoutInfo.totalItemsCount
            val lastVisibleItemIndex = layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0
            totalItemsCount to lastVisibleItemIndex
        }.collect { (totalItemsCount, lastVisibleItemIndex) ->

            if (lastVisibleItemIndex >= totalItemsCount - (if (isLoading) 2 else 1))  {

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
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF689F38), Color(0xFFAED581))
                    )
                )
                .padding(16.dp)
        ) {
            Column {
                Text(
                    text = report.titel,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
                Text(
                    text = report.fileUrl,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                )
            }
        }
    }
}

/*
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewReportsScreen() {
    ReportsScreen(navController = NavController(LocalContext.current))
}
*/

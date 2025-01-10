package com.example.folkedex.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info // Importer et andet ikon, hvis det er passende
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.zIndex
import androidx.navigation.NavController

data class Report(val title: String, val link: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportsScreen(onBackClick: () -> Unit = {}, onReportClick: (String) -> Unit = {}, navController: NavController) {
    // Dummy data untill we connect to the API
    val reports = listOf(
        Report(title = "Budget Proposal 2023", link = "https://www.ft.dk/budget2023"),
        Report(title = "Health Care Reform", link = "https://www.ft.dk/healthcarereform"),
        Report(title = "Climate Action Plan", link = "https://www.ft.dk/climateaction"),
    )

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .background(Color(0xFFAED581)), // Different color for Reports screen
                contentAlignment = Alignment.CenterStart
            ) {
                IconButton(
                    onClick = {navController.popBackStack()},
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .align(Alignment.CenterStart)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Tilbage",
                        tint = Color.White
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Icon(
                        imageVector = Icons.Default.Info, // Skift til et andet ikon, hvis ønsket
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
                    com.example.folkedex.ui.common.SearchBar(
                        modifier = Modifier
                            .padding(horizontal = 15.dp)
                    )
                }

                FolketingLogo(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset(x = -70.dp)
                        .offset(y = -1.dp)
                        .size(140.dp)
                        .zIndex(0f)
                )
            }
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 26.dp)
                    .padding(vertical = 26.dp)
            ) {
                items(reports) { report ->
                    ReportCard(
                        report = report,
                        onClick = { onReportClick(report.link) }
                    )
                }
            }
        }
    )
}


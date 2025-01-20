package com.example.folkedex.ui.theme
//weee
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info // Importer et andet ikon, hvis det er passende
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.folkedex.ui.common.FolketingLogo

data class Report(val title: String, val link: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportsScreen( onReportClick: (String) -> Unit = {}, navController: NavController) {

    var searchQuery by remember { mutableStateOf("") }

    val reports = listOf(
        Report(title = "Budget Proposal 2023", link = "https://www.ft.dk/budget2023"),
        Report(title = "Health Care Reform", link = "https://www.ft.dk/healthcarereform"),
        Report(title = "Climate Action Plan", link = "https://www.ft.dk/climateaction"),
    )

    val filteredReports = if (searchQuery.isBlank()) {
        reports
    } else {
        reports.filter { it.title.contains(searchQuery, ignoreCase = true) }
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

                    com.example.folkedex.ui.common.SearchBar(
                        value = searchQuery,
                        onValueChange = { newText ->
                            searchQuery = newText
                        },
                        onFocusChanged = {},
                        modifier = Modifier
                            .padding(horizontal = 15.dp)
                    )
                }
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
                items(filteredReports) { report ->
                    ReportCard(
                        report = report,
                        onClick = { onReportClick(report.link) }
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewReportsScreen() {
    ReportsScreen(navController = NavController(LocalContext.current))
}


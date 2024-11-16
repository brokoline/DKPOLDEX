package com.example.folkedex

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("News", style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)) },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFFFF6F61)),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Latest News",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(vertical = 16.dp)
                )

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(10) { // Placeholder how many news listed (currently 10)
                        NewsItemPlaceholder()
                    }
                }
            }
        }
    )
}

@Composable
fun NewsItemPlaceholder() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE0E0E0)),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(Color.Gray, shape = RoundedCornerShape(4.dp))
            ) {
                // placeholder for news thumbnail
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Coming Soon",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = "Stay tuned for updates!",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
        }
    }
}

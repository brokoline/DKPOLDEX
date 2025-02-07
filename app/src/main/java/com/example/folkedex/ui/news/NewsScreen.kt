package com.example.folkedex.ui.news

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.folkedex.R
import com.example.folkedex.ui.common.FolketingLogo

data class NewsItem(val title: String, val description: String, val url: String)

@Composable
fun NewsScreen(navController: NavController) {
    val newsList = listOf(
        NewsItem(
            title = "TV2 Politik",
            description = "News about politics from TV2.",
            url = "https://nyheder.tv2.dk/politik"
        ),
        NewsItem(
            title = "DR Politik",
            description = "Latest political news from DR.",
            url = "https://www.dr.dk/nyheder/politik"
        ),
        NewsItem(
            title = "Altinget Politik",
            description = "Insight into Danish politics from Altinget.",
            url = "https://www.altinget.dk"
        ),
        NewsItem(
            title = "Regeringen.dk",
            description = "Official news and initiatives from the government.",
            url = "https://www.regeringen.dk"
        ),
        NewsItem(
            title = "Folketinget,dk",
            description = "Documents and cases from the Folketing.",
            url = "https://www.ft.dk/da/dokumenter/dokumentlister/nyeste-sager"
        ),
        NewsItem(
            title = "DanskErhverv,dk",
            description = "News about danish business development, current political analyses and studies.",
            url = "https://www.danskerhverv.dk/politik-og-analyser/"
        )
    )

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color(0xFFF7C72E)),
                contentAlignment = Alignment.CenterStart
            ) {
                FolketingLogo(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset(x = (-50).dp)
                        .offset(y = (-5).dp)
                        .size(205.dp)
                        .zIndex(0f)
                )
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.newsicon),
                        contentDescription = "News Icon",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(bottom = 4.dp)
                    )
                    Text(
                        "News",
                        fontSize = 30.sp,
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )
                }
            }
        },
        content = { paddingValues ->
            LazyColumn(
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
                items(newsList) { news ->
                    NewsCard(newsItem = news)
                }
            }
        }
    )
}


@Composable
fun NewsCard(newsItem: NewsItem) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp)
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(16.dp))
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(newsItem.url))
                context.startActivity(intent)
            },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFFFCE4B), Color(0xFFFFE49A))
                    )
                )
                .padding(horizontal = 12.dp, vertical = 12.dp)
        ) {
            Column {
                Text(
                    text = newsItem.title,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
                Text(
                    text = newsItem.description,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp,
                        color = Color.White.copy(alpha = 0.8f)
                    ),
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}


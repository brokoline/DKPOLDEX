package com.example.folkedex.ui.news

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.folkedex.R
import com.example.folkedex.ui.common.FolketingLogo

data class NewsItem(val title: String, val description: String, val url: String)

@Composable
fun NewsScreen(onBackClick: () -> Unit = {}, navController: NavController) {
    val newsList = listOf(
        NewsItem(
            title = "TV2 Politik",
            description = "Nyheder om politik fra TV2.",
            url = "https://nyheder.tv2.dk/politik"
        ),
        NewsItem(
            title = "DR Politik",
            description = "Seneste politiske nyheder fra DR.",
            url = "https://www.dr.dk/nyheder/politik"
        ),
        NewsItem(
            title = "Altinget Politik",
            description = "Indblik i dansk politik fra Altinget.",
            url = "https://www.altinget.dk"
        ),
        NewsItem(
            title = "Regeringen.dk",
            description = "Officielle nyheder og initiativer fra regeringen.",
            url = "https://www.regeringen.dk"
        ),
        NewsItem(
            title = "Folketinget",
            description = "Dokumenter og sager fra Folketinget.",
            url = "https://www.ft.dk/da/dokumenter/dokumentlister/nyeste-sager"
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
                        .offset(x = -50.dp)
                        .offset(y = -5.dp)
                        .size(205.dp)
                        .zIndex(0f)
                )
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.padding(start = 16.dp)
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
                    .padding(paddingValues)
                    .padding(horizontal = 26.dp)
                    .padding(vertical = 26.dp)
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
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(newsItem.url))
            context.startActivity(intent)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
            
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF7C72E)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = newsItem.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = newsItem.description,
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    device = "spec:width=411dp,height=891dp,dpi=420"
)
@Composable
fun PreviewNewsScreen() {
    val navController = rememberNavController()
    NewsScreen(navController = navController)
}

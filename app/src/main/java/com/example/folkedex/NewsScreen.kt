package com.example.folkedex.ui.theme

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.folkedex.R

data class NewsItem(val title: String, val description: String, val date: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(onBackClick: () -> Unit = {}, onNewsClick: (String) -> Unit = {}, navController: NavController) {
    // Dummy-data til nyheder
    val newsList = listOf(
        NewsItem(
            title = "New climate policies announced",
            description = "The government announced new climate initiatives aiming to reduce emissions.",
            date = "14-11-2024"
        ),
        NewsItem(
            title = "Healthcare reform updates",
            description = "A detailed breakdown of the upcoming healthcare reforms.",
            date = "13-11-2024"
        ),
        NewsItem(
            title = "Budget proposal highlights",
            description = "Key takeaways from the 2024 budget proposal.",
            date = "12-11-2024"
        ),
        NewsItem(
            title = "Infrastructure developments",
            description = "Major projects planned for the next fiscal year.",
            date = "08-11-2024"
        )
    )

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color(0xFFF7C72E)), // Gult tema
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
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.newsicon), // Bruger dit nyhedsikon
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

                // Tilføjet FolketingLogo her
                FolketingLogo(modifier = Modifier.align(Alignment.CenterEnd))
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
                // Bruger newsList til at vise hvert NewsCard
                items(newsList) { news ->
                    NewsCard(newsItem = news, onClick = { onNewsClick(news.title) })
                }
            }
        }
    )
}

@Composable
fun NewsCard(newsItem: NewsItem, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFF59D) // Gule bokse
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
                fontWeight = FontWeight.Bold
            )
            Text(
                text = newsItem.description,
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 4.dp)
            )
            Text(
                text = "Date: ${newsItem.date}",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}
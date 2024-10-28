package com.example.folkedex.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen(onBackClick: () -> Unit = {}) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dine favoritter", style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)) },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFFFF6F61)),
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Tilbage",
                            tint = Color.White
                        )
                    }
                },
            )
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 26.dp)
                    .padding(vertical = 26.dp)
            ) {
                items(3) {
                    FavoriteCard()
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFFFF6F61),
                content = {
                    Button(
                        onClick = onBackClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                    ) {
                        Text(
                            text = "Tilbage til hovedmenu",
                            color = Color(0xFFFF6F61),
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp)
                        )
                    }
                }
            )
        }
    )
}

@Composable
fun FavoriteCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { /* Handle click here */ },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFFFCDD2), Color(0xFFFF8A80))
                    )
                )
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = android.R.drawable.ic_menu_gallery),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .padding(end = 16.dp),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Navn på Politiker",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                    Text(
                        text = "Partinavn",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.White,
                            )
                    )
                }

                IconButton(
                    onClick = { /* shall handle removing the favorite */ },
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorite",
                        tint = Color.White,
                    )
                }
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    device = "spec:width=411dp,height=891dp,dpi=420"
)
@Composable
fun PreviewFavoriteScreen() {
    FavoritesScreen()
}

package com.example.folkedex.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.folkedex.R
import com.example.folkedex.data.FavoritesHelper


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen(onBackClick: () -> Unit = {}, navController: NavController,
    cardWidth: Dp = 160.dp,
    cardHeight: Dp = 160.dp
){
    val context = LocalContext.current
    val favoriteManager = remember { FavoritesHelper(context) }
    val favorites = favoriteManager.getFavorites()

    val politicians = listOf(
        PoliticianData("Lars Løkke Rasmussen", R.drawable.politician_image, 0xFF6A1B9A),
        PoliticianData("Jakob Engel-Schmidt", R.drawable.flogo, 0xFF6A1B9A),
        PoliticianData("Mette Kierkgaard", R.drawable.flogo, 0xFF6A1B9A),
        PoliticianData("Henrik Frandsen", R.drawable.flogo, 0xFF6A1B9A),
        PoliticianData("Monika Rubin", R.drawable.flogo, 0xFF6A1B9A),
        PoliticianData("Charlotte Bagge Hansen", R.drawable.flogo, 0xFF6A1B9A),
        PoliticianData("Mohammad Rona", R.drawable.flogo, 0xFF6A1B9A)
    )

    val favoritePoliticians = politicians.filter { politician ->
        favorites.contains(politician.name)
    }

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color(0xFFFF6F61)),
                contentAlignment = Alignment.CenterStart
            ) {
                IconButton(
                    onClick = {navController.popBackStack()},
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .align(Alignment.CenterStart)
                ) {
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorites Heart Icon",
                        tint = Color.White,
                        modifier = Modifier
                            .size(100.dp)
                            .padding(bottom = 4.dp)
                    )
                    Text(
                        "Dine favoritter",
                        fontSize = 30.sp,
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )
                }

                // FolketingLogo composable
                FolketingLogo(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset(x = -50.dp)
                        .offset(y = -5.dp)
                        .size(200.dp)
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

                items(favoritePoliticians.chunked(2)) { rowPoliticians ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        rowPoliticians.forEach { politician ->
                            PoliticianCard(
                                politicianData = politician,
                                cardWidth = cardWidth,
                                cardHeight = cardHeight,
                                navController = navController
                            )
                        }

                        if (rowPoliticians.size == 1) {
                            Spacer(
                                modifier = Modifier
                                    .width(cardWidth)
                                    .height(cardHeight)
                            )
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewFavoritesScreen() {
    FavoritesScreen(navController = NavController(LocalContext.current))
}
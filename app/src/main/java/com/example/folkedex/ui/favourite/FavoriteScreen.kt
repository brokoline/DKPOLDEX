package com.example.folkedex.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.folkedex.data.FavoritesHelper
import com.example.folkedex.ui.common.FolketingLogo
import com.example.folkedex.ui.feature.PartyViewModel
import com.example.folkedex.ui.feature.PartyViewModelFactory
import com.example.folkedex.ui.politician.PoliticianCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen(
    navController: NavController,
    cardWidth: Dp = 160.dp,
    cardHeight: Dp = 160.dp
) {
    val context = LocalContext.current
    val viewModel: PartyViewModel = viewModel(factory = PartyViewModelFactory(context))
    val parties by viewModel.parties.collectAsState()

    val favoriteManager = FavoritesHelper(context)
    val favorites = favoriteManager.getFavorites()

    val favoritePoliticians = parties
        .flatMap { it.politicians }
        .filter { favorites.contains(it.navn) }

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color(0xFFFF6F61)),
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
                        "Your favorites",
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

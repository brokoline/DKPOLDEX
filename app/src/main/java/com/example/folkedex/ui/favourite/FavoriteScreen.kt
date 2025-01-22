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
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.folkedex.data.FavoritesHelper
import com.example.folkedex.data.local.DataStore
import com.example.folkedex.ui.common.FolketingLogo
import com.example.folkedex.ui.feature.PartyViewModel
import com.example.folkedex.ui.feature.PartyViewModelFactory
import com.example.folkedex.ui.politician.PoliticianCard
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import com.example.folkedex.ui.settings.exportFavoritesToFile


@Composable
fun FavoritesScreen(
    navController: NavController,
    cardWidth: Dp = 160.dp,
    cardHeight: Dp = 160.dp
) {
    val context = LocalContext.current
    val dataStore = DataStore(context)
    val viewModel: PartyViewModel = viewModel(factory = PartyViewModelFactory(dataStore))
    val parties by viewModel.parties.collectAsState()

    val favoriteManager = FavoritesHelper(context)
    val favorites = favoriteManager.getFavorites()

    val favoritePoliticians = parties
        .flatMap { it.politicians }
        .filter { favorites.contains(it.navn) }

    val scope = rememberCoroutineScope()
    val showConfirmationDialog = remember { mutableStateOf(false) }

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
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(paddingValues)
                        .padding(bottom = 20.dp)
                ) {
                    if (favoritePoliticians.isEmpty()) {
                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "No favorites yet.",
                                    fontSize = 20.sp,
                                    color = Color.Gray,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                    } else {
                        items(favoritePoliticians.chunked(2)) { rowPoliticians ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 6.dp),
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


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .align(Alignment.BottomCenter)
                        .background(Color.White)
                        .drawBehind {
                            drawLine(
                                color = Color.Transparent,
                                start = Offset(0f, 0f),
                                end = Offset(size.width, 0f),
                                strokeWidth = 2.dp.toPx()
                            )
                        }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Export Favorites",
                            style = MaterialTheme.typography.titleMedium.copy(color = Color.Black),
                            modifier = Modifier
                                .clickable {
                                    val message = exportFavoritesToFile(
                                        context,
                                        favoriteManager.getFavorites().toList()
                                    )
                                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                                }
                                .padding(horizontal = 8.dp)
                        )
                        Spacer(modifier = Modifier.width(52.dp))
                        Text(
                            text = "Reset Favorites",
                            style = MaterialTheme.typography.titleMedium.copy(color = Color.Red),
                            modifier = Modifier
                                .clickable {
                                    favoriteManager.clearFavorites()
                                    Toast.makeText(context, "Favorites cleared!", Toast.LENGTH_SHORT).show()
                                }
                                .padding(horizontal = 8.dp)
                        )
                    }
                }
                if (showConfirmationDialog.value) {
                    AlertDialog(
                        onDismissRequest = { showConfirmationDialog.value = false },
                        confirmButton = {
                            TextButton(
                                onClick = {
                                    favoriteManager.clearFavorites()
                                    showConfirmationDialog.value = false
                                    Toast.makeText(context, "Favorites cleared!", Toast.LENGTH_SHORT).show()
                                }
                            ) {
                                Text("Confirm", color = Color.Red)
                            }
                        },
                        dismissButton = {
                            TextButton(onClick = { showConfirmationDialog.value = false }) {
                                Text("Cancel")
                            }
                        },
                        title = { Text("Reset your favorites") },
                        text = { Text("Are you sure you want to reset all your favorites? This action cannot be undone.") }
                    )
                }
            }
        }
    )
}


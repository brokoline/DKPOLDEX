package com.example.folkedex.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.folkedex.R

@Composable
fun PoliticianSelectionScreen(navController: NavController,
    partyName: String = "Moderaterne",
    cardWidth: Dp = 160.dp,
    cardHeight: Dp = 160.dp
) {
    val scrollState = rememberLazyListState()
    var searchQuery by remember { mutableStateOf("") }

    // Dummy data for demonstration purposes
    val politicians = listOf(
        PoliticianData("Lars Løkke Rasmussen", R.drawable.politician_image, 0xFF6A1B9A),
        PoliticianData("Jakob Engel-Schmidt", R.drawable.flogo, 0xFF6A1B9A),
        PoliticianData("Mette Kierkgaard", R.drawable.flogo, 0xFF6A1B9A),
        PoliticianData("Henrik Frandsen", R.drawable.flogo, 0xFF6A1B9A),
        PoliticianData("Monika Rubin", R.drawable.flogo, 0xFF6A1B9A),
        PoliticianData("Charlotte Bagge Hansen", R.drawable.flogo, 0xFF6A1B9A),
        PoliticianData("Mohammad Rona", R.drawable.flogo, 0xFF6A1B9A)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Background logo
        Image(
            painter = painterResource(id = R.drawable.flogo),
            contentDescription = "Folketing Logo",
            modifier = Modifier
                .size(3000.dp)
                .padding(end = 16.dp)
                .offset(x = 150.dp, y = (-300).dp)
                .alpha(0.27f),
            contentScale = ContentScale.Fit
        )

        // Foreground with top bar and list
        Column {
            TopBarWithSearch(navController, partyName, searchQuery) { query ->
                searchQuery = query
            }

            LazyColumn(
                state = scrollState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val filteredPoliticians = politicians.filter {
                    it.name.contains(searchQuery, ignoreCase = true)
                }
                items(filteredPoliticians.chunked(2)) { rowPoliticians ->
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
    }
}

@Composable
fun TopBarWithSearch(
    navController: NavController,
    partyName: String,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(top = 30.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {navController.popBackStack()},
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }
            Text(
                text = "FolkeDex: $partyName",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(start = 50.dp)
            )
        }

        com.example.folkedex.ui.common.SearchBar()
    }
}

@Composable
fun PoliticianCard(
    politicianData: PoliticianData,
    navController: NavController,
    cardWidth: Dp = 160.dp,
    cardHeight: Dp = 160.dp
) {
    Column(
        modifier = Modifier
            .width(cardWidth)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(cardHeight - 40.dp)
                .background(
                    color = Color(politicianData.cardColor),
                    shape = RoundedCornerShape(16.dp)
                )
                .clickable {
                    navController.navigate("politician/${politicianData.name}")

                },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = politicianData.photo),
                contentDescription = "Photo of ${politicianData.name}",
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Crop
            )
        }

        Text(
            text = politicianData.name,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = MaterialTheme.typography.bodyLarge.fontSize * 1.3f,
                fontWeight = FontWeight.Bold
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        )
    }
}

// Data class for politicians
data class PoliticianData(
    val name: String,
    val photo: Int,
    val cardColor: Long
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPoliticianSelectionScreen() {
    val navController = rememberNavController()
    PoliticianSelectionScreen(navController)
}
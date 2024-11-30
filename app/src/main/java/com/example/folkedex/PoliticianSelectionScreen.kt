package com.example.folkedex.ui.theme

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.folkedex.R

@Composable
fun PoliticianSelectionScreen(
    navController: NavController,
    partyName: String,
    politicians: List<PoliticianData>,
    onBackClick: () -> Unit = {},
    cardWidth: Dp = 160.dp,
    cardHeight: Dp = 160.dp
) {
    val scrollState = rememberLazyListState()
    val isTopBarVisible by remember {
        derivedStateOf { scrollState.firstVisibleItemIndex == 0 && scrollState.firstVisibleItemScrollOffset == 0 }
    }
    var searchQuery by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Baggrundslogo
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

        // Forgrund med topbar og liste
        Column {
            TopBarWithSearch(partyName, onBackClick, searchQuery) { query ->
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
                                onClick = {
                                    // Navigér til politikerens detaljer
                                },
                                cardWidth = cardWidth,
                                cardHeight = cardHeight
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithSearch(
    partyName: String,
    onBackClick: () -> Unit,
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
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onBackClick,
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

        com.example.folkedex.SearchBar() // søgefelt skal rettes
    }
}

@Composable
fun PoliticianCard(
    politicianData: PoliticianData,
    onClick: () -> Unit,
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
                .clickable(onClick = onClick),
            contentAlignment = Alignment.Center
        ) {
            // Tilføjer billedet her
            Image(
                painter = painterResource(id = politicianData.photo),
                contentDescription = "Billede af ${politicianData.name}",
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Crop // Sikrer, at billedet passer
            )
        }

        // Tekst med navn
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


// Data-klasse til politikere
data class PoliticianData(
    val name: String,
    val photo: Int, // Ressource-ID til politikerens billede
    val cardColor: Long
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPoliticianSelectionScreen() {
    PoliticianSelectionScreen(
        navController = NavController(LocalContext.current),
        partyName = "Moderaterne",
        politicians = listOf(
            PoliticianData("Lars Løkke Rasmussen", R.drawable.politician_image, 0xFF6A1B9A),
            PoliticianData("Jakob Engel-Schmidt", R.drawable.flogo, 0xFF6A1B9A),
            PoliticianData("Mette Kierkgaard", R.drawable.flogo, 0xFF6A1B9A),
            PoliticianData("Henrik Frandsen", R.drawable.flogo, 0xFF6A1B9A),
            PoliticianData("Monika Rubin", R.drawable.flogo, 0xFF6A1B9A),
            PoliticianData("Charlotte Bagge Hansen", R.drawable.flogo, 0xFF6A1B9A),
            PoliticianData("Mohammad Rona", R.drawable.flogo, 0xFF6A1B9A),
            PoliticianData("Peter Have", R.drawable.flogo, 0xFF6A1B9A),
            PoliticianData("Nanna W. Gotfredsen", R.drawable.flogo, 0xFF6A1B9A),
            PoliticianData("Rasmus Lund-Nielsen", R.drawable.flogo, 0xFF6A1B9A),
            PoliticianData("Rosa Eriksen", R.drawable.flogo, 0xFF6A1B9A),
            PoliticianData("Karin Liltorp", R.drawable.flogo, 0xFF6A1B9A),
            PoliticianData("Henrik Rejnholt Andersen", R.drawable.flogo, 0xFF6A1B9A)


        )
    )
}

package com.example.folkedex.ui.politician

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.example.folkedex.R
import com.example.folkedex.data.local.PartyRepository
import com.example.folkedex.data.local.DataStore
import com.example.folkedex.data.model.Actor
import com.example.folkedex.utilities.extractPartyFromBiography
import com.example.folkedex.utilities.extractPoliPictureFromBiography
import com.example.folkedex.ui.feature.CollapsibleSearchTopAppBar
import com.example.folkedex.ui.party.PartyViewModel
import com.example.folkedex.ui.party.PartyViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PoliticianSelectionScreen(
    navController: NavController,
    partyName: String = "",
    cardWidth: Dp = 160.dp,
    cardHeight: Dp = 160.dp,
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val scrollState = rememberLazyListState()
    var searchQuery by remember { mutableStateOf("") }

    val context = LocalContext.current
    val dataStore = DataStore(context)
    val viewModel: PoliticianViewModel = viewModel(factory = PoliticianViewModelFactory(dataStore))

    val parties by viewModel.parties.collectAsState()
    val politicians = parties.find { it.name == partyName }?.politicians.orEmpty()
    val filteredPoliticians = if (searchQuery.isBlank()) {
        politicians
    } else {
        politicians.filter { it.navn.contains(searchQuery, ignoreCase = true) }
    }

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CollapsibleSearchTopAppBar(
                title = "FolkeDex: $partyName",
                searchQuery = searchQuery,
                onSearchQueryChange = { searchQuery = it },
                onBackClicked = { navController.popBackStack() },
                scrollBehavior = scrollBehavior,
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.flogo3),
                contentDescription = "Folketing Logo",
                modifier = Modifier
                    .size(3000.dp)
                    .background(color = Color.Transparent)
                    .padding(end = 16.dp)
                    .offset(x = 150.dp, y = (-300).dp)
                    .alpha(0.27f),
                contentScale = ContentScale.Fit
            )
            LazyColumn(
                state = scrollState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = innerPadding.calculateTopPadding()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
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
fun PoliticianCard(
    politicianData: Actor,
    navController: NavController,
    cardWidth: Dp = 160.dp,
    cardHeight: Dp = 160.dp
) {
    val party = politicianData.let {
        PartyRepository.parties.find { party ->
            party.path == extractPartyFromBiography(politicianData.biografi)
        }
    }
    Column(
        modifier = Modifier
            .width(cardWidth)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (party != null) {
            val photoUrl = extractPoliPictureFromBiography(politicianData.biografi)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(cardHeight - 40.dp)
                    .background(
                        color = party.cardColor,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .clickable {
                        navController.navigate("politician/${politicianData.navn}")
                    },
                contentAlignment = Alignment.Center
            ) {
                if (photoUrl != null) {
                    AsyncImage(
                        model = photoUrl,
                        contentDescription = "Photo of ${politicianData.navn}",
                        modifier = Modifier
                            .size(150.dp)
                            .clip(RoundedCornerShape(33.dp))
                            .padding(8.dp),
                        contentScale = ContentScale.Crop,
                        placeholder = painterResource(R.drawable.missingphoto),
                    )
                } else {
                    Image(
                        painter = painterResource(R.drawable.missingphoto),
                        contentDescription = "Photo of ${politicianData.navn}",
                        modifier = Modifier
                            .size(150.dp)
                            .clip(RoundedCornerShape(33.dp))
                            .padding(8.dp),
                        contentScale = ContentScale.Crop,
                    )
                }
            }

            Text(
                text = politicianData.navn,
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
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    device = "spec:width=411dp,height=891dp,dpi=420"
)
@Composable
fun PoliticianSelectionScreen() {
    val navController = rememberNavController()
    PoliticianSelectionScreen(navController = navController)
}

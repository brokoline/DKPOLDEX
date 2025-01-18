package com.example.folkedex.ui.politician

import android.util.Log
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.example.folkedex.R
import com.example.folkedex.data.PartyRepository
import com.example.folkedex.data.model.Actor
import com.example.folkedex.domain.extractPoliPictureFromBiography
import com.example.folkedex.model.PoliticianData
import com.example.folkedex.ui.feature.PartyViewModel
import com.example.folkedex.ui.feature.PartyViewModelFactory

@Composable
fun PoliticianSelectionScreen(
    navController: NavController,
    partyName: String = "",
    cardWidth: Dp = 160.dp,
    cardHeight: Dp = 160.dp,
) {
    val scrollState = rememberLazyListState()

    val context = LocalContext.current
    val viewModel: PartyViewModel = viewModel(
        factory = PartyViewModelFactory(context)
    )

    val parties by viewModel.parties.collectAsState()

    val politicians = parties.find { it.name == partyName }?.politicians.orEmpty()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
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

        Column {
            TopBarWithSearch(navController, partyName)

            LazyColumn(
                state = scrollState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(politicians.chunked(2)) { rowPoliticians ->
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
    partyName: String
) {
    Log.d("checking for bugs", "motherfcuker1")
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
                onClick = { navController.popBackStack() },
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
        var searchQuery = ""
        com.example.folkedex.ui.common.SearchBar(value = searchQuery,
            onValueChange = { searchQuery  = it })
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
        PartyRepository.parties.find { party -> party.name == politicianData.biografi }
    }
    Log.d("party test", party.toString())
    Column(
        modifier = Modifier
            .width(cardWidth)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Log.d("checking for bugs", "motherfucker2")
        if (party != null) {
            val photoUrl = extractPoliPictureFromBiography(politicianData.biografi)
            Log.d("checking for bugs", "picture should work3")
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
                Image(
                    painter = painterResource(R.drawable.flogo),
                    contentDescription = "Photo of ${politicianData.navn}",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(8.dp),
                    contentScale = ContentScale.Crop,
                )
                /*AsyncImage(
                    model = photoUrl,
                    contentDescription = "Photo of ${politicianData.navn}",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(8.dp),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(R.drawable.flogo),
                )*/
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPoliticianSelectionScreen() {
    val navController = rememberNavController()
    PoliticianSelectionScreen(navController)
}

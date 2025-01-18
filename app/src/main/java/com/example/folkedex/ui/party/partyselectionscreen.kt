package com.example.folkedex.ui.party

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.folkedex.R
import com.example.folkedex.data.PartyRepository
import com.example.folkedex.model.PartyData
import com.example.folkedex.data.PartyRepository
import com.example.folkedex.ui.feature.PartyViewModel
import com.example.folkedex.ui.feature.PartyViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


@Composable
fun PartySelectionScreen(navController: NavController, onBackClick: () -> Unit = {}, cardWidth: Dp = 160.dp, cardHeight: Dp = 160.dp) {
    val context = LocalContext.current
    val viewModel: PartyViewModel = viewModel(
        factory = PartyViewModelFactory(context)
    )

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            viewModel.fetchAndCachePartyData(context)
        }
    }
    val scrollState = rememberLazyListState(initialFirstVisibleItemIndex = 0)
    val isTopBarVisible by remember {
        derivedStateOf { scrollState.firstVisibleItemIndex == 0 && scrollState.firstVisibleItemScrollOffset == 0 }
    }

    Log.d("ScrollOffset", "Offset: ${remember { derivedStateOf { scrollState.firstVisibleItemScrollOffset } }}")


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Image(
            painter = painterResource(id = R.drawable.flogo),
            contentDescription = "folketinglogo",
            modifier = Modifier
                .size(3000.dp)
                .padding(end = 16.dp)
                .offset(x = 150.dp, y = (-300).dp)
                .alpha(0.27f),
            contentScale = ContentScale.Fit
        )


        Column{
            AnimatedVisibility(
                visible = isTopBarVisible,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp, vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = { navController.popBackStack() },
                            modifier = Modifier.padding(end = 0.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.Black
                            )
                        }
                        Text(
                            text = "FolkeDex",
                            color = Color.Black,
                            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .weight(1f)
                        )
                    }
                    Text(
                        text = "Select the relevant party",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontSize = MaterialTheme.typography.titleLarge.fontSize
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }

            LazyColumn(
                state = scrollState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(PartyRepository.parties.chunked(2)) { rowParties ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        rowParties.forEach { party ->
                            PartyCard(
                                partyData = party,
                                onClick = {
                                    navController.navigate(party.path)
                                },
                                cardWidth = cardWidth,
                                cardHeight = cardHeight
                            )
                        }


                        if (rowParties.size == 1) {
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
fun PartyCard(
    partyData: PartyData,
    onClick: () -> Unit,
    cardWidth: Dp = 180.dp,
    cardHeight: Dp = 150.dp
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
                    color = partyData.cardColor,
                    shape = RoundedCornerShape(16.dp)
                )
                .clickable(onClick = onClick),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = partyData.altLogo),
                contentDescription = "Logo for ${partyData.name}",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(partyData.logoSize)
            )
        }


        Text(
            text = partyData.name,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = MaterialTheme.typography.bodyLarge.fontSize * 1.4f
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
fun PreviewPartySelectionScreen() {
    PartySelectionScreen(navController = NavController(LocalContext.current))
}

package com.example.folkedex.ui.party

import android.annotation.SuppressLint
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.folkedex.R
import com.example.folkedex.data.local.PartyRepository
import com.example.folkedex.data.model.PartyData


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PartySelectionScreen(
    navController: NavController,
    cardWidth: Dp = 160.dp,
    cardHeight: Dp = 160.dp
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val scrollState = rememberLazyListState()
    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                scrollBehavior = scrollBehavior,
                title = {
                    IconButton(
                        onClick = { navController.popBackStack() },
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "FolkeDex",
                            color = Color.Black,
                            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .background(Color.Transparent),
                        )
                        Text(
                            text = "Select the relevant party",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontSize = MaterialTheme.typography.titleLarge.fontSize
                            ),
                            modifier = Modifier
                                .background(Color.Transparent)
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Color.Transparent,
                )
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.flogo3),
                contentDescription = "folketinglogo",
                modifier = Modifier
                    .background(Color.White)
                    .size(3000.dp)
                    .padding(end = 16.dp)
                    .offset(x = 150.dp, y = (-300).dp)
                    .alpha(0.27f),
                contentScale = ContentScale.Fit
            )
            LazyColumn(
                state = scrollState,
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxSize()
                    .padding(
                        top = innerPadding.calculateTopPadding()
                    ),
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
            text = partyData.structuredName,
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

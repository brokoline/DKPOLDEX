package com.example.folkedex.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.folkedex.R




@Composable
fun PartySelectionScreen( navController: NavHostController, onBackClick: () -> Unit = {}, cardWidth: Dp = 160.dp, cardHeight: Dp = 160.dp) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // background logo
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

        // foreground
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
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
                    fontSize = MaterialTheme.typography.h4.fontSize,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .offset(x = -10.dp)
                        .weight(1f)
                )
            }


            Text(
                text = "Select the relevant party",
                style = MaterialTheme.typography.subtitle1.copy(
                    fontSize = MaterialTheme.typography.h6.fontSize
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp),
                textAlign = TextAlign.Center
            )


            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp),
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
            style = MaterialTheme.typography.body1.copy(
                fontSize = MaterialTheme.typography.body1.fontSize * 1.4f
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        )
    }
}

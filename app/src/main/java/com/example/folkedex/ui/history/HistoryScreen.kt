package com.example.folkedex.ui.history

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.folkedex.model.PartyData
import com.example.folkedex.ui.common.FolketingLogo
import com.example.folkedex.ui.common.FolketingLogoWhite

@Composable
fun HistoryScreen(navController: NavHostController, partyData: PartyData) {
    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(partyData.backgroundColor),
            contentAlignment = Alignment.CenterStart
        ) {
            if ( partyData.path ==
                "Moderaterne" || partyData.path == "Socialdemokratiet"|| partyData.path == "Radikale Venstre" || partyData.path == "Socialistisk Folkeparti"|| partyData.path == "Enhedslisten"|| partyData.path == "Javnaðarflokkurin"|| partyData.path =="Inuit Ataqatigiit")  {
                FolketingLogoWhite(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset(x = (-50).dp)
                        .offset(y = (-5).dp)
                        .size(200.dp)
                        .zIndex(0f)
                )
            } else {
                FolketingLogo(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset(x = (-50).dp)
                        .offset(y = (-5).dp)
                        .size(200.dp)
                        .zIndex(0f)
                )}
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = partyData.backColor
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.offset(x = partyData.offsetX.dp, y = partyData.offsetY.dp)
            ) {
                Image(
                    painter = painterResource(id = partyData.logoRes),
                    contentDescription = "Centered Image",
                    modifier = Modifier
                        .size(partyData.imageSize)
                        .padding(bottom = 4.dp)
                )
                Text(
                    partyData.path,
                    fontSize = partyData.textSize,
                    color = partyData.backColor,
                    style = androidx.compose.material3.MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 200.dp),
            verticalArrangement = Arrangement.Top
        ) {
            item {
                Text(
                    text = partyData.history,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(horizontal = 16.dp)
                )
            }
        }
    }
}

package com.example.folkedex.ui.politician

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
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



@Composable
fun PoliciesScreen(navController: NavHostController, partyData: PartyData) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Top bar med baggrund og logo
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(partyData.backgroundColor),
            contentAlignment = Alignment.CenterStart
        ) {
            FolketingLogo(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .offset(x = -50.dp, y = -5.dp)
                    .size(205.dp)
                    .zIndex(0f)
            )
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
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

        // Policies-tekst i LazyColumn
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 200.dp), // Start under topbaren
            verticalArrangement = Arrangement.Top
        ) {
            item {
                Text(
                    text = partyData.policies,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp) // Horisontal padding
                )
            }
        }
    }
}


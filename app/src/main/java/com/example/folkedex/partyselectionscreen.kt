package com.example.folkedex.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.folkedex.R



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PartySelectionScreen(onBackClick: () -> Unit = {}, navController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "FolkeDex",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black // Make text color black for better contrast
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.White) // Set to white
            )
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // This chunked(2) will help in forming rows of 2 cards each
                items(getFullPartyList().chunked(2)) { rowParties ->
                    PartyRow(rowParties = rowParties, onPartyClick = { partyName ->

                        navController.navigate(partyName) })
                }
            }
        }
    )
}

@Composable
fun PartyRow(rowParties: List<Pair<String, Int>>, onPartyClick: (String) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        rowParties.forEach { (partyName, logoResId) ->
            PartyCard(partyName = partyName, logoResId = logoResId, onPartyClick = onPartyClick)
        }
    }
}

@Composable
fun PartyCard(partyName: String, logoResId: Int, onPartyClick: (String) -> Unit) {
    // Complementary card colors to enhance readability while keeping a party-like theme
    val cardColor = when (partyName) {
        "Socialdemokratiet" -> Color(0xFFF5B0B7)
        "Venstre" -> Color(0xFFA5C8E1)
        "Liberal Alliance" -> Color(0xFFFFD580)
        "Konservative" -> Color(0xFFA9E5B3)
        "Enhedslisten" -> Color(0xFFFFA3A7)
        "Dansk Folkeparti" -> Color(0xFF8EA8E8)
        "Danmarksdemokraterne" -> Color(0xFFFFB085)
        "Socialistisk Folkeparti" -> Color(0xFFFF9AA3)
        "Radikale Venstre" -> Color(0xFFDE8ABF)
        "Alternativet" -> Color(0xFFB9E6A5)
        "Moderaterne" -> Color(0xFFC28AD4)
        "Det Konservative Folkeparti" -> Color(0xFFA9E5B3)
        "Siumut" -> Color(0xFFFF9A9A)
        "Inuit Ataqatigiit" -> Color(0xFFA8EFB3)
        "Sambandsflokkurin" -> Color(0xFFA3C1E5)
        "Javnaðarflokkurin" -> Color(0xFFFFA8A8)
        else -> Color(0xFFE0E0E0)
    }

    Card(
        modifier = Modifier
            .size(150.dp)
            .clickable { onPartyClick(partyName) },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = logoResId),
                contentDescription = partyName,
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = partyName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black, // Black text to contrast against lighter card colors
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

fun getFullPartyList(): List<Pair<String, Int>> {
    return listOf(
        "Socialdemokratiet" to R.drawable.socialdemokratiet_logo,
        "Venstre" to R.drawable.venstre_logo,
        "Liberal Alliance" to R.drawable.liberal_alliance_logo,
        "Det Konservative Folkeparti" to R.drawable.konservative_logo,
        "Enhedslisten" to R.drawable.enhedslisten_logo,
        "Dansk Folkeparti" to R.drawable.dansk_folkeparti_logo,
        "Danmarksdemokraterne" to R.drawable.danmarksdemokraterne_logo,
        "Socialistisk Folkeparti" to R.drawable.socialistisk_folkeparti_logo,
        "Radikale Venstre" to R.drawable.radikale_venstre_logo,
        "Alternativet" to R.drawable.alternativet_logo,
        "Moderaterne" to R.drawable.moderaterne_logo,
        "Det Konservative Folkeparti" to R.drawable.konservative_logo,
        "Siumut" to R.drawable.siumut_logo,
        "Inuit Ataqatigiit" to R.drawable.inuit_ataqatigiit_logo,
        "Sambandsflokkurin" to R.drawable.sambandsflokkurin_logo,
        "Javnaðarflokkurin" to R.drawable.javnadarflokkurin_logo
    )
}



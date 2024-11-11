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
import com.example.folkedex.R

class PartySelectionScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PartySelectionScreen(onPartyClick = { /* Handle party selection */ })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PartySelectionScreen(onPartyClick: (String) -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "FolkeDex",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF842990))
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
                items(getFullPartyList().chunked(2)) { rowParties ->
                    PartyRow(rowParties = rowParties, onPartyClick = onPartyClick)
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
    val cardColor = when (partyName) {
        "Socialdemokratiet" -> Color(0xFFE2001A)
        "Venstre" -> Color(0xFF0056A3)
        "Liberal Alliance" -> Color(0xFFFBB040)
        "Konservative" -> Color(0xFF006B3F)
        "Enhedslisten" -> Color(0xFFEE1C25)
        "Dansk Folkeparti" -> Color(0xFF002D72)
        "Danmarksdemokraterne" -> Color(0xFFDD571C)
        "Socialistisk Folkeparti" -> Color(0xFFBE1E2D)
        "Radikale Venstre" -> Color(0xFF890C58)
        "Alternativet" -> Color(0xFF63A744)
        "Moderaterne" -> Color(0xFF702082)
        "Det Konservative Folkeparti" -> Color(0xFF006B3F)
        "Siumut" -> Color(0xFFBF0000)
        "Inuit Ataqatigiit" -> Color(0xFF009F3D)
        "Sambandsflokkurin" -> Color(0xFF003366)
        "Javnaðarflokkurin" -> Color(0xFFCC0000)
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
                color = Color.White,
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
        "Konservative" to R.drawable.konservative_logo,
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

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewPartySelectionScreen() {
    PartySelectionScreen(onPartyClick = { /* Handle click */ })
}

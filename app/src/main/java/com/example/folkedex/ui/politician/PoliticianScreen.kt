package com.example.folkedex.ui.politician

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.folkedex.data.PartyRepository
import com.example.folkedex.model.PartyData
import com.example.folkedex.model.PoliticianData
import com.example.folkedex.ui.party.Party

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PoliticianScreen(navController: NavController, name: String) {
    val politician = PartyRepository.parties
        .flatMap { it.politicians }
        .find { it.navn == name }
    val party = PartyRepository.parties
        .flatMap { it. }

    if (politician != null) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(politician.navn) },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = Color(party.),
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    )
                )
            },
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = politician.photo),
                        contentDescription = "Photo of ${politician.name}",
                        modifier = Modifier
                            .size(300.dp)
                            .padding(8.dp)
                            .background(Color(politician.cardColor), shape = RoundedCornerShape(8.dp))
                            .padding(4.dp),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    PoliticianDetails(politician)
                }
            }
        )
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Politician data not found",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Red
            )
        }
    }
}

@Composable
fun PoliticianDetails(politician: PoliticianData) {
    val details = mapOf(
        "Name" to politician.name,
        "Party" to politician.partyName,
        "Age" to politician.age,
        "Occupation" to politician.occupation,
        "Email" to politician.email,
        "Phone" to politician.phone
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFEDE7F6), shape = RoundedCornerShape(12.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        details.forEach { (key, value) ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "$key:",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color.Black
                )
                Text(
                    text = value.toString(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.DarkGray
                )
            }
        }
    }
}

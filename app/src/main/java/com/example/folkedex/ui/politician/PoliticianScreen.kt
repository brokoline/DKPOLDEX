package com.example.folkedex.ui.politician


import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.folkedex.R
import com.example.folkedex.data.local.DataStore
import com.example.folkedex.data.local.FavoritesHelper
import com.example.folkedex.data.local.PartyRepository
import com.example.folkedex.data.model.Actor
import com.example.folkedex.utilities.extractPartyFromBiography
import com.example.folkedex.utilities.extractPoliAgeFromBiography
import com.example.folkedex.utilities.extractPoliEducationFromBiography
import com.example.folkedex.utilities.extractPoliMailFromBiography
import com.example.folkedex.utilities.extractPoliPhoneFromBiography
import com.example.folkedex.utilities.extractPoliPictureFromBiography
import com.example.folkedex.utilities.extractPoliProfFromBiography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PoliticianScreen(navController: NavController, name: String) {
    val context = LocalContext.current
    val dataStore = DataStore(context)
    val viewModel: PoliticianViewModel = viewModel(factory = PoliticianViewModelFactory(dataStore))
    val parties by viewModel.parties.collectAsState()

    val politician = parties
        .flatMap { it.politicians }
        .find { it.navn == name }
    val party = politician?.let {
        PartyRepository.parties.find { party -> party.path == extractPartyFromBiography(politician.biografi) }
    }

    val favoritesHelper = remember { FavoritesHelper(context) }
    var isFavorite by remember { mutableStateOf(favoritesHelper.getFavorites().contains(name)) }

    if (politician != null) {
        val photoUrl = extractPoliPictureFromBiography(politician.biografi)
        Scaffold(
            topBar = {
                if (party != null) {
                    TopAppBar(
                        title = { Text(politician.navn) },
                        navigationIcon = {
                            IconButton(onClick = { navController.popBackStack() }) {
                                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                            }
                        },
                        actions = {
                            IconButton(
                                onClick = {
                                    if (isFavorite) {
                                        favoritesHelper.removeFavorite(name)
                                    } else {
                                        favoritesHelper.addFavorite(name)
                                    }
                                    isFavorite = !isFavorite
                                }
                            ) {
                                Box {
                                    Icon(
                                        imageVector = Icons.Default.Favorite,
                                        contentDescription = null,
                                        tint = Color.Black,
                                        modifier = Modifier
                                            .scale(1.1f)
                                    )

                                    Icon(
                                        imageVector = Icons.Default.Favorite,
                                        contentDescription = "Favorite",
                                        tint = if (isFavorite) Color.Red else Color.White
                                    )
                                }
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = party.cardColor,
                            titleContentColor = Color.White,
                            navigationIconContentColor = Color.White
                        )
                    )
                }
            },
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                        .padding(paddingValues)
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (party != null && photoUrl != null) {
                        AsyncImage(
                            model = photoUrl,
                            contentDescription = "Photo of ${politician.navn}",
                            modifier = Modifier
                                .size(300.dp)
                                .padding(8.dp)
                                .background(party.cardColor, shape = RoundedCornerShape(8.dp))
                                .padding(4.dp),
                            contentScale = ContentScale.Crop,
                            placeholder = painterResource(R.drawable.flogo3),
                        )
                    } else {
                        Image(
                            painter = painterResource(R.drawable.missingphoto),
                            contentDescription = "Photo of ${politician.navn}",
                            modifier = Modifier
                                .size(300.dp)
                                .clip(RoundedCornerShape(33.dp))
                                .padding(8.dp),
                            contentScale = ContentScale.Crop,
                        )
                    }

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
fun PoliticianDetails(politician: Actor) {
    val details = mapOf(
        "Name" to politician.navn,
        "Party" to (extractPartyFromBiography(politician.biografi) ?: "?"),
        "Born" to (extractPoliAgeFromBiography(politician.biografi) ?: "?"),
        "Profession" to (extractPoliProfFromBiography(politician.biografi) ?: "?"),
        "Education" to (extractPoliEducationFromBiography(politician.biografi) ?: "?"),
        "Email" to (extractPoliMailFromBiography(politician.biografi) ?: "?"),
        "Phone" to (extractPoliPhoneFromBiography(politician.biografi) ?: "?")
    )

    val context = LocalContext.current

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

                if (key == "Email" && value != "?") {
                    Text(
                        text = value,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.Blue,
                            textDecoration = TextDecoration.Underline
                        ),
                        textAlign = TextAlign.End,
                        modifier = Modifier.clickable {
                            val intent = Intent(Intent.ACTION_SENDTO).apply {
                                data = Uri.parse("mailto:$value")
                            }
                            context.startActivity(intent)
                        }
                    )
                } else if (key == "Phone" && value != "?") {
                    Text(
                        text = value,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.Blue,
                            textDecoration = TextDecoration.Underline
                        ),
                        textAlign = TextAlign.End,
                        modifier = Modifier.clickable {
                            val intent = Intent(Intent.ACTION_DIAL).apply {
                                data = Uri.parse("tel:$value")
                            }
                            context.startActivity(intent)
                        }
                    )
                } else {
                    Text(
                        text = value,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.DarkGray,
                        textAlign = TextAlign.End
                    )
                }
            }
        }
    }
}

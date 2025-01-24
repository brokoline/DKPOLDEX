package com.example.folkedex.ui.policies

import android.webkit.WebView
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.folkedex.data.model.PartyData
import com.example.folkedex.ui.common.FolketingLogo
import com.example.folkedex.ui.common.FolketingLogoWhite


@Composable
fun PoliciesScreen(navController: NavHostController, partyData: PartyData) {
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
                        .offset(x = -50.dp)
                        .offset(y = -5.dp)
                        .size(200.dp)
                        .zIndex(0f)
                )
            } else {
                FolketingLogo(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset(x = -50.dp)
                        .offset(y = -5.dp)
                        .size(200.dp)
                        .zIndex(0f)
                )}
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
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(1.5f))
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
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.weight(0.5f))
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 200.dp),
            verticalArrangement = Arrangement.Top
        ) {
            item {
                AndroidView(
                    factory = { context ->
                        WebView(context).apply {
                            settings.javaScriptEnabled = false
                            loadDataWithBaseURL(null, partyData.policies, "text/html", "UTF-8", null)
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}


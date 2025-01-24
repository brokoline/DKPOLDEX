package com.example.folkedex.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.folkedex.R
import com.example.folkedex.data.model.PartyData

@Composable
fun FolketingLogo(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.flogo3),
        contentDescription = "Folketing Logo",
        modifier = modifier
            .size(300.dp)
            .padding(end = 16.dp)
            .offset(x = 100.dp, y = (-40).dp)
            .alpha(1.0f)
    )
}
@Composable
fun FolketingLogoWhite(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.flogo_white),
        contentDescription = "Folketing Logo",
        modifier = modifier
            .size(300.dp)
            .padding(end = 16.dp)
            .offset(x = 100.dp, y = (-40).dp)
            .alpha(1.0f)
    )
}

@Composable
fun FolkeLogo(
    partyData: PartyData
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(partyData.backgroundColor),
        contentAlignment = Alignment.CenterStart
    ) {
        if (partyData.path ==
            "Moderaterne" || partyData.path == "Socialdemokratiet" || partyData.path == "Radikale Venstre" || partyData.path == "Socialistisk Folkeparti" || partyData.path == "Enhedslisten" || partyData.path == "Javnaðarflokkurin" || partyData.path == "Inuit Ataqatigiit"
        ) {
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
            )
        }
    }
}
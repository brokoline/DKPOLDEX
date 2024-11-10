package com.example.folkedex.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.folkedex.R

object PartyRepository {
    val parties = listOf(
        PartyData(
            name = "Moderaterne",
            logoRes = R.drawable.moderaterne,
            description = "Text about the Moderaterne party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            backgroundColor = ModeraterneBackground,
            buttonColor = ModeraterneButton,
            offsetX = 80f,
            imageSize = 120.dp,
            textSize = 40.sp

        ),
        PartyData(
            name = "Venstre",
            logoRes = R.drawable.venstre,
            description = "Text about the Venstre party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            backgroundColor = VenstreBackground,
            buttonColor = VenstreButton,
            offsetX = 130f,
            imageSize = 130.dp,   // Default image size for Moderaterne
            textSize = 40.sp
        ),
        PartyData(
            name = "Socialdemokratiet",
            logoRes = R.drawable.socialdemokratiet,
            description = "Text about the Socialdemokratiet party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            backgroundColor = SocialdemokratietBackground,
            buttonColor = SocialdemokratietButton,
            offsetX = 30f,
            imageSize = 130.dp,   // Default image size for Moderaterne
            textSize = 40.sp
        ),
        PartyData(
            name = " Radikale Venstre",
            logoRes = R.drawable.radikalevenstre,
            description = "Text about the Socialdemokratiet party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            backgroundColor = VenstreBackground,
            buttonColor = VenstreButton,
            offsetX = 40f,
            imageSize = 130.dp,   // Default image size for Moderaterne
            textSize = 40.sp
        ),
        PartyData(
            name = "Det Konservative Folkeparti",
            logoRes = R.drawable.koservative,
            description = "Text about the Socialdemokratiet party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            backgroundColor = KonservativBackground,
            buttonColor = KonservativButton,
            offsetX = 10f,
            offsetY = 20f,
            imageSize = 75.dp,
            textSize = 30.sp
        ),
        PartyData(
            name = "Socialistisk Folkeparti",
            logoRes = R.drawable.socialistiskfolkeparti,
            description = "Text about the Socialdemokratiet party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            backgroundColor = SfBackground,
            buttonColor = SfButton,
            offsetX = 35f,
            offsetY = 25f,
            imageSize = 75.dp,
            textSize = 30.sp
        ),
        PartyData(
            name = " Liberal Alliance",
            logoRes = R.drawable.liberalalliance,
            description = "Text about the Socialdemokratiet party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            backgroundColor = SocialdemokratietBackground,
            buttonColor = SocialdemokratietButton,
            offsetX = 50f,
            offsetY = 25f,
            imageSize = 90.dp,
            textSize = 40.sp
        ),
        PartyData(
            name = "Dansk Folkeparti",
            logoRes = R.drawable.df,
            description = "Text about the Socialdemokratiet party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            backgroundColor = SocialdemokratietBackground,
            buttonColor = SocialdemokratietButton,
            offsetX = 80f,
            offsetY = 15f,
            imageSize = 100.dp,
            textSize = 30.sp
        ),
        PartyData(
            name = "Danmarksdemokraterne",
            logoRes = R.drawable.ddemkraterne,
            description = "Text about the Socialdemokratiet party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            backgroundColor = SocialdemokratietBackground,
            buttonColor = SocialdemokratietButton,
            offsetX = 30f,
            offsetY = 10f,
            imageSize = 100.dp,
            textSize = 30.sp
        ),
        PartyData(
            name = " Enhedslisten",
            logoRes = R.drawable.enhedslisten,
            description = "Text about the Socialdemokratiet party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            backgroundColor = SocialdemokratietBackground,
            buttonColor = SocialdemokratietButton,
            offsetX = 90f,
            offsetY = 15f,
            imageSize = 90.dp,
            textSize = 35.sp
        ),
        PartyData(
            name = "Alternativet",
            logoRes = R.drawable.alternativet,
            description = "Text about the Socialdemokratiet party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            backgroundColor = SocialdemokratietBackground,
            buttonColor = SocialdemokratietButton,
            offsetX = 80f,
            imageSize = 100.dp,
            textSize = 40.sp
        ),
        PartyData(
            name = "Sambandsflokkurin",
            logoRes = R.drawable.sambands,
            description = "Text about the Socialdemokratiet party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            backgroundColor = SocialdemokratietBackground,
            buttonColor = SocialdemokratietButton,
            offsetX = 70f,
            offsetY = 15f,
            imageSize = 100.dp,
            textSize = 30.sp
        ),
        PartyData(
            name = "Javnaðarflokkurin",
            logoRes = R.drawable.javn,
            description = "Text about the Socialdemokratiet party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            backgroundColor = SocialdemokratietBackground,
            buttonColor = SocialdemokratietButton,
            offsetX = 80f,
            offsetY = 15f,
            imageSize = 110.dp,   // Default image size for Moderaterne
            textSize = 30.sp
        ),
        PartyData(
            name = "Siumut",
            logoRes = R.drawable.siumut,
            description = "Text about the Socialdemokratiet party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            backgroundColor = black,
            buttonColor = SocialdemokratietButton,
            offsetX = 130f,
            offsetY = 20f,
            imageSize = 110.dp,
            textSize = 30.sp
        ),
        PartyData(
            name = "Inuit Ataqatigiit",
            logoRes = R.drawable.inuit,
            description = "Text about the Socialdemokratiet party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            backgroundColor = SocialdemokratietBackground,
            buttonColor = SocialdemokratietButton,
            offsetX = 90f,
            offsetY = 15f,
            imageSize = 100.dp,
            textSize = 30.sp
        ),
        PartyData(
            name = "løsgænger",
            logoRes = R.drawable.loes,
            description = "Text about the Socialdemokratiet party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            backgroundColor = SocialdemokratietBackground,
            buttonColor = SocialdemokratietButton,
            offsetX = 125f,
            offsetY = 15f,
            imageSize = 100.dp,
            textSize = 30.sp
        ),
    )
    fun getPartyByName(name: String): PartyData? {
        return parties.find { it.name == name }
    }
}

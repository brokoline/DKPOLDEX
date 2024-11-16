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
            history = "This party was founded...",
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
            history = "This party was founded...",
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
            history = "This party was founded...",
            backgroundColor = SocialdemokratietBackground,
            buttonColor = SocialdemokratietButton,
            offsetX = 30f,
            imageSize = 130.dp,   // Default image size for Moderaterne
            textSize = 40.sp
        ),
        PartyData(
            name = "Radikale Venstre",
            logoRes = R.drawable.radikalevenstre,
            description = "Text about the Radikale Venstre party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = RadikalevenstreBackground,
            buttonColor = RadikalevenstreButton,
            offsetX = 40f,
            imageSize = 130.dp,   // Default image size for Moderaterne
            textSize = 40.sp
        ),
        PartyData(
            name = "Det Konservative Folkeparti",
            logoRes = R.drawable.koservative,
            description = "Text about the Konservative Folkeparti party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
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
            description = "Text about the Socialistisk Folkeparti party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = SfBackground,
            buttonColor = SfButton,
            offsetX = 35f,
            offsetY = 25f,
            imageSize = 75.dp,
            textSize = 30.sp
        ),
        PartyData(
            name = "Liberal Alliance",
            logoRes = R.drawable.liberalalliance,
            description = "Text about the  Liberal Alliance party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = LaBackground,
            buttonColor = LaButton,
            offsetX = 50f,
            offsetY = 25f,
            imageSize = 90.dp,
            textSize = 40.sp
        ),
        PartyData(
            name = "Dansk Folkeparti",
            logoRes = R.drawable.df,
            description = "Text about the Dansk Folkeparti party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = DanskfolkepartiBackground,
            buttonColor = DanskfolkepartiButton,
            offsetX = 80f,
            offsetY = 15f,
            imageSize = 100.dp,
            textSize = 30.sp
        ),
        PartyData(
            name = "Danmarksdemokraterne",
            logoRes = R.drawable.ddemkraterne,
            description = "Text about the Danmarksdemokraterne party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = DanmarksdemokraterneBackground,
            buttonColor = DanmarksdemokraterneButton,
            offsetX = 30f,
            offsetY = 10f,
            imageSize = 100.dp,
            textSize = 30.sp
        ),
        PartyData(
            name = "Enhedslisten",
            logoRes = R.drawable.enhedslisten,
            description = "Text about the Enhedslisten party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = EnhedslistenBackground,
            buttonColor = EnhedslistenButton,
            offsetX = 90f,
            offsetY = 15f,
            imageSize = 90.dp,
            textSize = 35.sp
        ),
        PartyData(
            name = "Alternativet",
            logoRes = R.drawable.alternativet,
            description = "Text about the Alternativet party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = AlternativetBackground,
            buttonColor = AlternativetButton,
            offsetX = 80f,
            imageSize = 100.dp,
            textSize = 40.sp
        ),
        PartyData(
            name = "Sambandsflokkurin",
            logoRes = R.drawable.sambands,
            description = "Text about the Sambandsflokkurin party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = SambandspartietBackground,
            buttonColor = SambandspartietButton,
            offsetX = 70f,
            offsetY = 15f,
            imageSize = 100.dp,
            textSize = 30.sp
        ),
        PartyData(
            name = "Javnaðarflokkurin",
            logoRes = R.drawable.javn,
            description = "Text about the Javnaðarflokkurin party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = JavnBackground,
            buttonColor = JavnButton,
            offsetX = 80f,
            offsetY = 15f,
            imageSize = 110.dp,   // Default image size for Moderaterne
            textSize = 30.sp
        ),
        PartyData(
            name = "Siumut",
            logoRes = R.drawable.siumut,
            description = "Text about the Siumut party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = SiumutBackground,
            buttonColor = SiumutButton,
            offsetX = 130f,
            offsetY = 20f,
            imageSize = 110.dp,
            textSize = 30.sp
        ),
        PartyData(
            name = "Inuit Ataqatigiit",
            logoRes = R.drawable.inuit,
            description = "Text about the Inuit Ataqatigiit party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = InuitBackground,
            buttonColor = InuitButton,
            offsetX = 90f,
            offsetY = 15f,
            imageSize = 100.dp,
            textSize = 30.sp
        ),
        PartyData(
            name = "Løsgængere",
            logoRes = R.drawable.loes,
            description = "Text about the politicians who currently aren't in any party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
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

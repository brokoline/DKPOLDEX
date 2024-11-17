package com.example.folkedex.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.folkedex.R

object PartyRepository {
    val parties = listOf(
        PartyData(
            name = "Moderaterne",
            path = "Moderaterne",
            logoRes = R.drawable.moderaterne,
            altLogo = R.drawable.moderaterne_logo,
            description = "Text about the Moderaterne party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = ModeraterneBackground,
            cardColor = altModeraterne,
            buttonColor = ModeraterneButton,
            offsetX = 80f,
            imageSize = 120.dp,
            logoSize = 160.dp,
            textSize = 40.sp,
            backColor =Color.White

        ),
        PartyData(
            name = "Venstre",
            path = "Venstre",
            logoRes = R.drawable.venstre,
            altLogo = R.drawable.venstre_logo,
            description = "Text about the Venstre party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = VenstreBackground,
            cardColor = altVenstre,
            buttonColor = VenstreButton,
            offsetX = 130f,
            imageSize = 130.dp,
            logoSize = 80.dp,
            textSize = 40.sp,
            backColor =Color.White
        ),
        PartyData(
            name = "Socialdemokratiet",
            path = "Socialdemokratiet",
            logoRes = R.drawable.socialdemokratiet,
            altLogo = R.drawable.socialdemokratiet_logo,
            description = "Text about the Socialdemokratiet party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = SocialdemokratietBackground,
            cardColor = altSocialdemokratiet,
            buttonColor = SocialdemokratietButton,
            offsetX = 30f,
            imageSize = 130.dp,
            logoSize =80.dp,
            textSize = 40.sp,
            backColor =Color.White
        ),
        PartyData(
            name = "Radikale Venstre",
            path = "Radikale Venstre",
            logoRes = R.drawable.radikalevenstre,
            altLogo = R.drawable.radikale_venstre_logo,
            description = "Text about the Radikale Venstre party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = RadikalevenstreBackground,
            cardColor = altRadikaleVenstre,
            buttonColor = RadikalevenstreButton,
            offsetX = 40f,
            imageSize = 130.dp,
            logoSize = 120.dp,
            textSize = 40.sp,
            backColor =Color.White
        ),
        PartyData(
            name = "Det Konservative Folkeparti",
            path = "Det Konservative Folkeparti",
            logoRes = R.drawable.koservative,
            altLogo = R.drawable.konservative_logo,
            description = "Text about the Konservative Folkeparti party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = KonservativBackground,
            cardColor = altKonservative,
            buttonColor = KonservativButton,
            offsetX = 10f,
            offsetY = 20f,
            imageSize = 75.dp,
            logoSize = 100.dp,
            textSize = 30.sp,
            backColor =Color.White
        ),
        PartyData(
            name = "Socialistisk Folkeparti",
            path = "Socialistisk Folkeparti",
            logoRes = R.drawable.socialistiskfolkeparti,
            altLogo = R.drawable.socialistisk_folkeparti_logo,
            description = "Text about the Socialistisk Folkeparti party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = SfBackground,
            cardColor = altSocialistiskFolkeparti,
            buttonColor = SfButton,
            offsetX = 35f,
            offsetY = 25f,
            imageSize = 75.dp,
            logoSize = 120.dp,
            textSize = 30.sp,
            backColor =Color.White
        ),
        PartyData(
            name = "Liberal Alliance",
            path = "Liberal Alliance",
            logoRes = R.drawable.liberalalliance,
            altLogo = R.drawable.liberal_alliance_logo,
            description = "Text about the  Liberal Alliance party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = LaBackground,
            cardColor = altLiberalAlliance,
            buttonColor = LaButton,
            offsetX = 50f,
            offsetY = 25f,
            imageSize = 90.dp,
            logoSize = 120.dp,
            textSize = 40.sp,
            backColor =Color.Black
        ),
        PartyData(
            name = "Dansk Folkeparti",
            path = "Dansk Folkeparti",
            logoRes = R.drawable.df,
            altLogo = R.drawable.dansk_folkeparti_logo,
            description = "Text about the Dansk Folkeparti party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = DanskfolkepartiBackground,
            cardColor = altDanskFolkeparti,
            buttonColor = DanskfolkepartiButton,
            offsetX = 80f,
            offsetY = 15f,
            imageSize = 100.dp,
            logoSize = 120.dp,
            textSize = 30.sp,
            backColor =Color.White
        ),
        PartyData(
            name = "Danmarks-\ndemokraterne",
            path = "Danmarksdemokraterne",
            logoRes = R.drawable.ddemkraterne,
            altLogo = R.drawable.danmarksdemokraterne_logo,
            description = "Text about the Danmarksdemokraterne party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = DanmarksdemokraterneBackground,
            cardColor = altDanmarksdemokraterne,
            buttonColor = DanmarksdemokraterneButton,
            offsetX = 30f,
            offsetY = 10f,
            imageSize = 100.dp,
            logoSize = 120.dp,
            textSize = 30.sp,
            backColor =Color.White
        ),
        PartyData(
            name = "Enhedslisten",
            path = "Enhedslisten",
            logoRes = R.drawable.enhedslisten,
            altLogo = R.drawable.enhedslisten_logo,
            description = "Text about the Enhedslisten party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = EnhedslistenBackground,
            cardColor = altEnhedslisten,
            buttonColor = EnhedslistenButton,
            offsetX = 90f,
            offsetY = 15f,
            imageSize = 90.dp,
            logoSize = 120.dp,
            textSize = 35.sp,
            backColor =Color.White
        ),
        PartyData(
            name = "Alternativet",
            path = "Alternativet",
            logoRes = R.drawable.alternativet,
            altLogo = R.drawable.alternativet_logo,
            description = "Text about the Alternativet party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = AlternativetBackground,
            cardColor = altAlternativet,
            buttonColor = AlternativetButton,
            offsetX = 80f,
            imageSize = 100.dp,
            logoSize = 120.dp,
            textSize = 40.sp,
            backColor =Color.White
        ),
        PartyData(
            name = "Sambands-\nflokkurin",
            path = "Sambandsflokkurin",
            logoRes = R.drawable.sambands,
            altLogo = R.drawable.sambandsflokkurin_logo,
            description = "Text about the Sambandsflokkurin party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = SambandspartietBackground,
            cardColor = altSambandsflokkurin,
            buttonColor = SambandspartietButton,
            offsetX = 70f,
            offsetY = 15f,
            imageSize = 100.dp,
            logoSize = 120.dp,
            textSize = 30.sp,
            backColor =Color.White
        ),
        PartyData(
            name = "Javnaðarflokkurin",
            path = "Javnaðarflokkurin",
            logoRes = R.drawable.javn,
            altLogo = R.drawable.javnlogo2,
            description = "Text about the Javnaðarflokkurin party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = JavnBackground,
            cardColor = altJavnaðarflokkurin,
            buttonColor = JavnButton,
            offsetX = 80f,
            offsetY = 15f,
            imageSize = 110.dp,
            logoSize = 120.dp,
            textSize = 30.sp,
            backColor =Color.White
        ),
        PartyData(
            name = "Siumut",
            path = "Siumut",
            logoRes = R.drawable.siumut,
            altLogo = R.drawable.siumut_logo,
            description = "Text about the Siumut party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = SiumutBackground,
            cardColor = altSiumut,
            buttonColor = SiumutButton,
            offsetX = 130f,
            offsetY = 20f,
            imageSize = 110.dp,
            logoSize = 120.dp,
            textSize = 30.sp,
            backColor =Color.White
        ),
        PartyData(
            name = "Inuit Ataqatigiit",
            path = "Inuit Ataqatigiit",
            logoRes = R.drawable.inuit,
            altLogo = R.drawable.inuit_ataqatigiit_logo,
            description = "Text about the Inuit Ataqatigiit party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = InuitBackground,
            cardColor = altInuitAtaqatigiit,
            buttonColor = InuitButton,
            offsetX = 90f,
            offsetY = 15f,
            imageSize = 100.dp,
            logoSize = 120.dp,
            textSize = 30.sp,
            backColor =Color.White
        ),
        PartyData(
            name = "Løsgængere",
            path = "Løsgængere",
            logoRes = R.drawable.loes,
            altLogo = R.drawable.loesgaengere,
            description = "Text about the politicians who currently aren't in any party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "This party was founded...",
            backgroundColor = SocialdemokratietBackground,
            cardColor = altSocialdemokratiet,
            buttonColor = SocialdemokratietButton,
            offsetX = 125f,
            offsetY = 15f,
            imageSize = 100.dp,
            logoSize = 120.dp,
            textSize = 30.sp,
            backColor =Color.White
        ),
    )
    fun getPartyByName(name: String): PartyData? {
        return parties.find { it.name == name }
    }
}

package com.example.folkedex.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.folkedex.R
import com.example.folkedex.model.PartyData
import com.example.folkedex.model.PoliticianData
import com.example.folkedex.ui.theme.AlternativetBackground
import com.example.folkedex.ui.theme.AlternativetButton
import com.example.folkedex.ui.theme.DanmarksdemokraterneBackground
import com.example.folkedex.ui.theme.DanmarksdemokraterneButton
import com.example.folkedex.ui.theme.DanskfolkepartiBackground
import com.example.folkedex.ui.theme.DanskfolkepartiButton
import com.example.folkedex.ui.theme.EnhedslistenBackground
import com.example.folkedex.ui.theme.EnhedslistenButton
import com.example.folkedex.ui.theme.InuitBackground
import com.example.folkedex.ui.theme.InuitButton
import com.example.folkedex.ui.theme.JavnBackground
import com.example.folkedex.ui.theme.JavnButton
import com.example.folkedex.ui.theme.KonservativBackground
import com.example.folkedex.ui.theme.KonservativButton
import com.example.folkedex.ui.theme.LaBackground
import com.example.folkedex.ui.theme.LaButton
import com.example.folkedex.ui.theme.ModeraterneBackground
import com.example.folkedex.ui.theme.ModeraterneButton
import com.example.folkedex.ui.theme.RadikalevenstreBackground
import com.example.folkedex.ui.theme.RadikalevenstreButton
import com.example.folkedex.ui.theme.SambandspartietBackground
import com.example.folkedex.ui.theme.SambandspartietButton
import com.example.folkedex.ui.theme.SfBackground
import com.example.folkedex.ui.theme.SfButton
import com.example.folkedex.ui.theme.SiumutBackground
import com.example.folkedex.ui.theme.SiumutButton
import com.example.folkedex.ui.theme.SocialdemokratietBackground
import com.example.folkedex.ui.theme.SocialdemokratietButton
import com.example.folkedex.ui.theme.VenstreBackground
import com.example.folkedex.ui.theme.VenstreButton
import com.example.folkedex.ui.theme.altAlternativet
import com.example.folkedex.ui.theme.altDanmarksdemokraterne
import com.example.folkedex.ui.theme.altDanskFolkeparti
import com.example.folkedex.ui.theme.altEnhedslisten
import com.example.folkedex.ui.theme.altInuitAtaqatigiit
import com.example.folkedex.ui.theme.altJavnaðarflokkurin
import com.example.folkedex.ui.theme.altKonservative
import com.example.folkedex.ui.theme.altLiberalAlliance
import com.example.folkedex.ui.theme.altModeraterne
import com.example.folkedex.ui.theme.altRadikaleVenstre
import com.example.folkedex.ui.theme.altSambandsflokkurin
import com.example.folkedex.ui.theme.altSiumut
import com.example.folkedex.ui.theme.altSocialdemokratiet
import com.example.folkedex.ui.theme.altSocialistiskFolkeparti
import com.example.folkedex.ui.theme.altVenstre

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
            backColor =Color.White,
            politicians = listOf(
                PoliticianData(
                    id = 1,
                    name = "Lars Løkke Rasmussen",
                    photo = R.drawable.politician_image,
                    cardColor = 0xFF6A1B9A,
                    partyName = "Moderaterne",
                    age = 60,
                    occupation = "Formand for Moderaterne",
                    email = "KaptajnUnderbuks@StatenBetaler.dk",
                    phone = 42334123
                )
            )

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
            backColor =Color.White,
            politicians = listOf(
                PoliticianData(
                    id = 8,
                    name = "Jakob Ellemann-Jensen",
                    photo = R.drawable.flogo,
                    cardColor = 0xFF01288F,
                    partyName = "Venstre",
                    age = 51,
                    occupation = "Formand for Venstre",
                    email = "Dellemann@KingOfBurger.dk",
                    phone = 42334123
                )
            )
        ),
        PartyData(
            name = "Socialdemo-\nkratiet",
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
            logoRes = R.drawable.konserative,
            altLogo = R.drawable.konserative,
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
            logoRes = R.drawable.liberal_alliance_logo,
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
            backColor =Color.White
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
            name = "Javnaðar-\nflokkurin",
            path = "Javnaðarflokkurin",
            logoRes = R.drawable.javna,
            altLogo = R.drawable.javna,
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
            logoRes = R.drawable.siumut_logo,
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
    fun getPoliticiansByParty(partyName: String): List<PoliticianData> {
        return parties.find { it.name == partyName }?.politicians ?: emptyList()
    }
}

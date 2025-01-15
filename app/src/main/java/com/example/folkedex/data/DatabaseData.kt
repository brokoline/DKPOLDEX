package com.example.folkedex.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.folkedex.R
import com.example.folkedex.model.PartyData

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
            history = "Moderaterne was founded in 2022 by Lars Løkke Rasmussen with a focus on centrist policies and pragmatic solutions.",
            website = "https://moderaterne.dk",
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
            history = "Venstre, Denmark's Liberal Party, was founded in 1870 and has historically represented agriculture and business interests.",
            website = "https://venstre.dk",
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
            history = "Socialdemokratiet was founded in 1871 as Denmark's first workers' party, focusing on social justice and welfare policies.",
            website = "https://socialdemokratiet.dk",
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
            history = "Radikale Venstre was founded in 1905 as a party focusing on social liberalism and education policies.",
            website = "https://radikale.dk",
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
            history = "Det Konservative Folkeparti was founded in 1915 and has roots in the former Højre party, focusing on private property rights and tradition.",
            website = "https://konservative.dk",
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
            history = "Socialistisk Folkeparti was founded in 1959 by Aksel Larsen after a split from DKP, focusing on socialism and environmental policies.",
            website = "https://sf.dk",
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
            history = "Liberal Alliance was founded in 2007 and focuses on lower taxes, individual freedom, and less government regulation.",
            website = "https://liberalalliance.dk",
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
            history = "Dansk Folkeparti was founded in 1995 by Pia Kjærsgaard and has primarily focused on nationalism and immigration policies.",
            website = "https://danskfolkeparti.dk",
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
            name = "Danmarksdemokraterne",
            path = "Danmarksdemokraterne",
            logoRes = R.drawable.ddemkraterne,
            altLogo = R.drawable.danmarksdemokraterne_logo,
            description = "Text about the Danmarksdemokraterne party, \n" +
                    "eventually what they stand for,\n" +
                    "political orientation/spectrum\n" +
                    "placement, when they were founded,\n" +
                    "etc etc.",
            history = "Danmarksdemokraterne was founded in 2022 by Inger Støjberg, focusing on national conservative values.",
            website = "https://danmarksdemokraterne.dk",
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
            history = "Enhedslisten was founded in 1989 as a coalition of left-wing parties focusing on equality and environmental protection.",
            website = "https://enhedslisten.dk",
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
            history = "Alternativet was founded in 2013 focusing on sustainability, green policies, and rethinking democracy.",
            website = "https://alternativet.dk",
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
            history = "Sambandsflokkurin is a Faroese party founded in 1906 focusing on union with Denmark.",
            website = "https://samband.fo",
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
            history = "Javnaðarflokkurin is a Faroese social democratic party founded in 1925 focusing on equality and welfare.",
            website = "https://j.fo",
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
            history = "Siumut is a Greenlandic social democratic party founded in 1977, focusing on self-governance and indigenous rights.",
            website = "https://siumut.gl",
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
            history = "Inuit Ataqatigiit is a Greenlandic left-wing party founded in 1976 focusing on independence and environmental protection.",
            website = "https://ia.gl",
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
            website = "https://www.ft.dk/da/ofte-stillede-spoergsmaal/medl_hvad-er-en-loesgaenger",
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

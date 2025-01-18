package com.example.folkedex.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.folkedex.R
import com.example.folkedex.data.model.Actor
import com.example.folkedex.domain.extractPartyFromBiography
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
import com.example.folkedex.ui.theme.*





object PartyRepository {
    fun mapActorsToParties(actors: List<Actor>, parties: List<PartyData>): List<PartyData> {
        val actorsByParty = actors.groupBy { actor ->
            val partyName = extractPartyFromBiography(actor.biografi)?.trim()
            when (partyName) {
                "Uden for folketingsgrupperne" -> "Løsgængere"
                else -> partyName
            }
        }

        return parties.map { party ->
            val matchingActors = actorsByParty[party.path] ?: emptyList()
            party.copy(politicians = matchingActors)
        }
    }
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
            policies = "Danmark er et fantastisk land. Et godt sted at vokse op, stifte familie og blive gammel. På mange måder har vi fundet opskriften på et samfund med en god balance mellem lighed, frihed og tryghed. Det er solsiden af fortællingen om Danmark. Og det er en sand fortælling.\n" +
                    "\n" +
                    "Men – hånden på hjertet – der er også en skyggeside:\n" +
                    "\n" +
                    "Vores velfærd er grundlæggende udfordret på kerneopgaven både demografisk, økonomisk og strukturelt.\n" +
                    "\n" +
                    "For mange unge opbygger ikke faglige færdigheder og personlig robusthed til få fodfæste på arbejdsmarkedet.\n" +
                    "For mange idéer og initiativer bliver ikke omsat til arbejdspladser og velstand, fordi vi mangler kvalificeret arbejdskraft og taber i konkurrence til andre lande med mere attraktive investeringsvilkår.\n" +
                    "For mange ældre medborgere får ikke en værdig pleje og omsorg.\n" +
                    "For mange mennesker lever på kanten af samfundet uden at være en aktiv del af fællesskabet.\n" +
                    "For mange med anden etnisk baggrund end dansk er ikke fuldt deltagende i arbejds- og samfundslivet.\n" +
                    "Og vores sygehusvæsen – som ellers har leveret f.eks. langt bedre kræftbehandling over de sidste snart mange år – er under voldsomt pres. Ikke bare fra Covid-19-pandemien, men fra demografi, livstilssygdomme og uattraktive arbejdsvilkår.\n" +
                    "\n" +
                    "Det er også en sand beskrivelse af Danmark!\n" +
                    "\n" +
                    "MODERATERNE har et brændende ønske om at finde løsningerne og samle de ansvarlige partier om at løse de udfordringer, der ellers sander til i fastlåste højre-venstre-positioner. Det er sådan, at vi forløser drømmen om at skabe et endnu bedre Danmark med frihed, frisind, virkelyst og fremgang.\n" +
                    "\n" +
                    "Vi har ikke patent på den drøm. Heldigvis. Men det er ikke nok at drømme; der skal handles for at realisere drømmen. Og vi er forbi det punkt, hvor det kan ske med en ekstra milliard til offentligt forbrug, en finjustering af skatteskruen eller smarte slogans om velfærdslove, der lover mere end de holder, eller symbolske værdipolitiske meldinger uden reel effekt.\n" +
                    "\n" +
                    "For få tør tænke nyt eller højt. De politiske blokke lurer på hinanden. For meget handler om dagens avisoverskrift og morgendagens meningsmåling – for lidt om, hvad vi for alvor skal forandre, hvis vi ikke bare vil fastholde, men udbygge vores velfærd, velstand og muligheder.",
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
            policies = "True social security and welfare is based on a high level of private production financing the welfare. We cannot in the long term carry on maintaining a high living standard and an extensive social security system by becoming indebted. Curbing the national and foreign debts of Denmark is therefore a central objective for our economic policies. Venstre's economic policy is aiming at a stable and sustainable growth of employment. Economic policies should build on four corner stones; low inflation rate; low interest rates; fixed currency rate and sound and stable public finance. The national budget should be balanced; public debts bring about problems of tax distribution and carry forward tax burdens into the next generation.\n" +
                    "\n" +
                    "Venstre works for a gradual lowering of the tax burden. Progress in a society is based on the principle that it is worth while having a job, saving, investing and taking risks. This is why society should stimulate private initiative and independence everywhere.\n" +
                    "\n" +
                    "Venstre stands for a free market economy, - both because it fulfills most efficiently people's individual wishes and needs, and because the individual person has a basic right to interact with other people. A free market economy ensures dynamic growth and innovation in both material and non material values.\n" +
                    "\n" +
                    "Venstre wants social security with the highest freedom of choice. We have a responsibility for people who cannot look after themselves. The stronger has to look after the weaker. This is why we have to co-finance hospitals, nursing homes and other institutions and that we are economically and socially secured when we get old, if we become ill and unemployed. The welfare system should ensure that its citizens can have the highest freedom of choice and the strictest control of public finance. Liberal politics is to combine social security with the highest possible level of freedom and independence for the individual citizens.\n" +
                    "\n" +
                    "It is important to stimulate qualitative growth. The advance in technology can bring about interesting possibilities of growth in the quality of life if we conscientiously use it for creating a better framework for family life and human contact, cultural life and education. New technology could also contribute to ensuring a cleaner environment and better working conditions. Also the individual citizen is responsible for taking care of the environment by reducing the use of products with a heavy environmental impacts and by reducing the amount of waste.\n" +
                    "\n" +
                    "The backbone of a liberal environmental policy is the \"polluter-pays principle\". Economic incentives should make it attractive to protect and improve the environment. Venstre is on guard against totalitarian powers being bestowed on governments in the name of environmental protection. An efficient protection of the environment should be linked with freedom and market economy.\n" +
                    "\n" +
                    "Pollution does not respect borders, which is why it should be combatted through international cooperation. The European cooperation should be strengthened. Environmental taxes should have a positive impact on the environment. The principle therefore has to be that the consumer or the producer should be able to avoid or reduce environmental taxes by changing ways of consumption or manufacturing.\n" +
                    "\n" +
                    "Environmental taxes should not increase the overall tax burden but constitute an economical incentive for environmentally friendly behaviour.\n" +
                    "\n" +
                    "A liberal industrial policy builds on the assumption that private companies know better than public authorities what will become future products or areas of growth. Businesses should be allowed to make a profit in order to develop new products and invest in new manufacturing. The source of innovation are the entrepreneurs. They discover new niches and start a new production in order to fill these niches. They develop new, better and cheaper methods of production. This is why it should become easier to establish and run a company.",
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
            backColor =Color.White,
            policies = ""
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
            backColor =Color.White,
            policies = ""
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
            backColor =Color.White,
            policies = ""
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
            backColor =Color.White,
            policies = ""
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
            backColor =Color.White,
            policies = ""
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
            backColor =Color.White,
            policies = ""
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
            backColor =Color.White,
            policies = ""
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
            backColor =Color.White,
            policies = ""
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
            backColor =Color.Black,
            policies = ""
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
            backColor =Color.White,
            policies = ""
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
            backColor =Color.White,
            policies = ""
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
            backColor =Color.White,
            policies = ""
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
            backColor =Color.White,
            policies = ""
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
            backColor =Color.White,
            policies = ""
        ),

    )
    var cachedParties: List<PartyData> = emptyList()
    fun getPartyByName(name: String): PartyData? {
        return parties.find { it.name == name }
    }
    fun getPoliticiansByParty(partyName: String): List<PoliticianData> {
        return parties.find { it.name == partyName }?.politicians ?: emptyList()
    }
}

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
            description = "Moderaterne was founded in 2022 by Lars Løkke Rasmussen with a focus on centrist policies and pragmatic solutions.",
            history = "The Moderates (Danish: Moderaterne) is a liberal political party in Denmark founded by former Prime Minister and current Minister of Foreign Affairs Lars Løkke Rasmussen. He announced the name in a foundational speech on 5 June 2021. At the same time, he said that his main scenario was that the party would be formed after the 2021 Danish local elections. The name was, according to Rasmussen, inspired by the fictitious Prime Minister Birgitte Nyborg's party Moderaterne in the hit political TV drama Borgen as well as the Swedish Moderate Party, the then–second largest party in the Swedish Riksdag. The Moderates' political position is referred to as centre to centre-right.\n" +
                    "\n" +
                    "According to Rasmussen, Moderaterne is a centrist party that has the ambition to create \"progress and change in a crossroads between a blue bloc that is tormented by value politics and a red bloc that is stuck in a past view of individual and state\". Thus, it is not aligned with either bloc in the Folketing. The party began collecting voting declarations in June 2021. On 15 September 2021 Lars Løkke Rasmussen announced that they had received the 20,182 signatures needed to be eligible to stand in the 2022 Danish general election.\n" +
                    "\n" +
                    "The Moderates saw a surge in popularity during campaigning for the 2022 general election, eventually ending up as the third largest party with 16 seats, as polls had suggested. They had positioned themselves as kingmakers in deciding who the next prime minister should be, but the incumbent red bloc won a majority, thus preventing the Moderates from having the decisive seats in the next government. Despite this, the Moderates entered negotiations with the Social Democrats and Venstre and successfully formed a grand coalition government, the Frederiksen II Cabinet.",
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
            description = "Venstre, Denmark's Liberal Party, was founded in 1870 and has historically represented agriculture and business interests.",
            history = "Venstre, full name Venstre, Danmarks Liberale Parti (English: Left, Denmark's Liberal Party), is a conservative-liberal, agrarian political party in Denmark. Founded as part of a peasants' movement against the landed aristocracy, today it espouses an economically liberal, pro-free-market ideology.\n" +
                    "\n" +
                    "Venstre is the major party of the centre-right in Denmark, and the second-largest party in the country. The party has produced many Prime Ministers. In the 2022 general elections, Venstre received 13.3% of the vote and 23 out of 179 seats. Following the resignation of Jakob Ellemann-Jensen, the party is led by Troels Lund Poulsen who serves as the country's Deputy Prime Minister. Since December 2022, the party has been a junior partner in the second Frederiksen government.\n" +
                    "\n" +
                    "The party is a member of Liberal International and the Alliance of Liberals and Democrats for Europe (ALDE) and has four MEPs in the European Parliament.\n" +
                    "\n" +
                    "1870–1910 Venstre was founded in 1870 under the name \"Det Forenede Venstre\" (lit. 'The United Left'). Originally, the party consisted of multiple conflicting groups, all united under the classical liberal (then the standard left-wing) ideology, the safeguarding of farmers' interests and opposition to the then right-wing classical conservative party Højre (literally \"Right\"). After the party in 1872 gained an absolute majority in the Folketing, it became the leading voice in the battle for parliamentarism, whereafter the party in 1895 split in two, Venstrereformpartiet (\"Venstre Reform Party\") and Det Moderate Venstre (\"The Moderate Left\"). In 1905, social liberal factions split from the party and formed Radikale Venstre (also known as the Danish Social Liberal Party), and in 1910 Venstrereformpartiet and Det Moderate Venstre reunited again under the name Venstre.",
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
            description = "Socialdemokratiet was founded in 1871 as Denmark's first workers' party, focusing on social justice and welfare policies.",
            history = "Socialdemokratiet is a political party in Denmark that adheres to the political ideology of democratic socialism, occasionally referred to as social democracy, which, however, is not an ideology.\n" +
                    "\n" +
                    "The party traces its history back to the International Working Association for Denmark, founded in 1871 and banned in 1873, which was loosely reorganized into the movement Det Socialdemokratiske Arbejderparti. In 1876, it issued the Gimle Program. Formally, it was first established in 1878 as the Social Democratic Union. This was the formal name for almost a hundred years. In practice, a number of other names were used until it was renamed to Socialdemokratiet i Danmark in 1965. At a congress in Aalborg in 2002, the party changed its name to Socialdemokraterne, but since 2016, it has again been known simply as Socialdemokratiet. Socialdemokratiet uses the letter A in elections, but the abbreviation S is often used in the media. The party's classic symbol is a red rose or, more recently, an A in a red circle.\n" +
                    "\n" +
                    "The history of Socialdemokratiet began in the autumn of 1871, when the three socialists Louis Pio, Harald Brix, and Paul Geleff came together and founded the International Working Association for Denmark as the Danish branch of the First International. The International Working Association was organized into professional sections and functioned both as a professional organization and a political party. The purpose was to organize the rapidly growing working class on a democratic, socialist basis. Since the mid-century, Denmark had been undergoing an industrialization process. Large groups from the poor rural population moved to the cities and became workers, and Socialdemokratiet emerged from the demand to provide this population group with fair living conditions and democratic rights.\n" +
                    "\n" +
                    "After the Battle of Fælleden in 1872, the three leaders were imprisoned and, by a Supreme Court ruling in 1873, sentenced to many years in prison, which also led Justice Minister C.S. Klein to issue a ban on the association. Local workers' associations continued the political and professional work. They saw themselves as part of the same movement, loosely called Det Socialdemokratiske Arbejderparti, and held a congress in 1876 at the assembly house Gimle in Frederiksberg, where they issued Socialdemokratiet's first program, the Gimle Program.\n" +
                    "\n" +
                    "In 1878, the political work was reorganized with the creation of a formal political party, Socialdemokratisk Forbund. This separated the trade union movement and the political work of the labor movement. However, the two branches of the labor movement worked closely together and were ensured representation in each other's governing bodies through the statutes. In the next 70 years, the party's membership steadily grew to over 300,000 by 1948. Concurrently, the labor movement built an extensive organizational network through the establishment of a wide range of affiliated organizations such as cooperative enterprises, educational associations, and workers' high schools, covering practically all aspects of life.",
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
            description = "Radikale Venstre was founded in 1905 as a party focusing on social liberalism and education policies.",
            history = "The Danish Social Liberal Party (Danish: Radikale Venstre, RV, lit. 'Radical Left') is a social-liberal political party in Denmark. The party was founded as a split from the Venstre Reform Party in 1905.\n" +
                    "\n" +
                    "Historically, the centrist party has played a central role in Danish politics and has supported governments on both sides of the political spectrum, as cooperation is a primary belief of the party. A pro-European party, it is a member of Liberal International and the ALDE, and has one MEP in the Renew Europe group in the European Parliament.\n" +
                    "\n" +
                    "The party was founded in 1905 as a split from Venstre. The initial impetus was the expulsion of Venstre's antimilitarist wing from the party in January 1905. The expelled members held a founding conference for the new party in Odense on 21 May 1905. In addition to the differences over military spending, the social liberals also took a more positive view than Venstre towards measures that aimed to reduce social inequality. The party also became the political leg of the cultural radical movement. The party was cautiously open to aspects of the welfare state and also advocated reforms to improve the position of smallholders, an important early group of supporters. The party's social-liberal ideals are said to have been inspired by the political economists Henry George and John Stuart Mill. Until 1936, the party was a member of the International Entente of Radical and Similar Democratic Parties.\n" +
                    "\n" +
                    "The first Social Liberal Cabinet was formed in 1909 with Carl Theodor Zahle serving as Prime Minister (1909–1910). From 1913 to 1920, Zahle led the second Social Liberal Cabinet with the Social Democrats serving as parliamentary support, keeping Denmark neutral during World War I. During the Great Depression of the 1930s, the party served as coalition partners along with the Social Democrats, led by Prime Minister Thorvald Stauning, and managed to lead the country through the recession by implementing far-reaching social reforms.",
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
            name = "Konservative Folkeparti",
            path = "Konservative Folkeparti",
            logoRes = R.drawable.konserative,
            altLogo = R.drawable.konserative,
            description = "The Konservative Folkeparti was founded in 1915 and has roots in the former Højre party, focusing on private property rights and traditions.",
            history = "The Conservative People's Party (Danish: Det Konservative Folkeparti, DKF), also known as The Conservatives (De Konservative), is a centre-right political party in Denmark. The party is a member of the International Democracy Union and the European People's Party.\n" +
                    "\n" +
                    "The party was founded in 1916 based mostly on its predecessor, Højre (\"Right\") after its downfall, but also on the Free Conservatives and a moderate faction of the liberal party Venstre (\"Left\"). The party was a part of the coalition government during World War II, where the leader John Christmas Møller provided the voice for BBC London's daily radio to Denmark. However, while a number of conservatives participated in the resistance movement, some conservatives were sympathetic to fascist ideology, and the youth wing of the party praised several fascist movements in Europe during the 1930s.\n" +
                    "\n" +
                    "Since World War II, the party has participated in several coalition governments, but only one Prime Minister of Denmark, Poul Schlüter, has come from this party; he served as prime minister from 1982 to 1993. His government had to resign after the Tamil Case, when the Justice Minister, Erik Ninn-Hansen (himself a former Conservative leader), was impeached.\n" +
                    "\n" +
                    "The party used its first logo in 1950, consisting of the serif-letter \"C\" coloured green. On 24 August 2000, the Conservative People's Party rebranded itself as the Conservatives, and at the same time retired its 50-year-old green serif-letter \"C\" logo, thus launching a new logo for the first time since 1950. The new logo was a circle which contains a chartreuse circle with the letter \"C\".\n" +
                    "\n" +
                    "From the 2001 parliament elections until 2011, the Conservative People's Party was the junior partner in a coalition government led by Venstre. In the 2004 European parliament elections, the party won a seat. Four months later, on 23 October 2004, it adopted a logo consisting of a green circle-squared box that contains a dark-green screen with the letter \"C\" that is coloured green; the \"Konservative\" wordmark is placed below the symbol, though it too is also coloured green. The member is currently Bendt Bendtsen, who is a member of the EPP Group in the European Parliament. In the 2014 European election, the party garnered 9.1% of the national vote, retaining Bendtsen's seat as MEP.\n" +
                    "\n" +
                    "In the 2011 parliamentary election for the Folketing (Danish national parliament), the Conservative People's Party won eight seats, 10 fewer than it had won in the previous election in 2007, and it received 4.9% of the vote, placing the party in eighth place nationally. On 27 September 2013, the Conservative People's Party received the current version of its logo: the colour of the letter \"C\" was changed to white, the circle-square retained its dark-green colour, and the circle-squared line was removed from it. At the same time, the party gave up being known as the Conservatives, reverting to its former name as the Conservative People's Party.\n" +
                    "\n" +
                    "At the 2015 election, the party did badly and was reduced to a mere six seats, which made it the smallest party in the Folketing. But Søren Pape Poulsen (who had taken over as leader the previous year) managed to double the party's seats to 12 in the 2019 election with 6.6% of the vote. After that election, several opinion polls indicated that the party enjoyed wider popular support than Venstre, but at the 2022 election gained just 5.5%, following an election campaign significantly influenced by affairs concerning Pape Poulsen's personal life. Poulsen died suddenly at the age of 52 on 2 March 2024, leaving the party leadership vacant.",
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
            description = "Socialistisk Folkeparti was founded in 1959 by Aksel Larsen after a split from DKP, focusing on socialism and environmental policies.",
            history = "",
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
            description = "Liberal Alliance was founded in 2007 and focuses on lower taxes, individual freedom, and less government regulation.",
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
            description = "Dansk Folkeparti was founded in 1995 by Pia Kjærsgaard and has primarily focused on nationalism and immigration policies.",
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
            description = "Danmarksdemokraterne was founded in 2022 by Inger Støjberg, focusing on national conservative values.",
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
            description = "Enhedslisten was founded in 1989 as a coalition of left-wing parties, focusing on equality and environmental protection.",
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
            description = "Alternativet was founded in 2013 focusing on sustainability, green policies, and rethinking democracy.",
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
            description = "Sambandsflokkurin is a Faroese party founded in 1906 focusing on union with Denmark.",
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
            name = "Javnaðarflokkurin",
            path = "Javnaðarflokkurin",
            logoRes = R.drawable.javna,
            altLogo = R.drawable.javna,
            description = "Javnaðarflokkurin is a Faroese social democratic party founded in 1925 focusing on equality and welfare.",
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
            description = "Siumut is a Greenlandic social democratic party founded in 1977, focusing on self-governance and indigenous rights.",
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
            description = "Inuit Ataqatigiit is a Greenlandic left-wing party founded in 1976 focusing on independence and environmental protection.",
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
            description = "An løsgænger (independent) is a member of the Danish Parliament who does not belong to any of the party groups in the Danish Parliament. An independent is called outside the parliamentary groups (UFG).",
            history = "An independent is a member of the Danish Parliament who does not belong to any of the party groups in the Danish Parliament. An independent is called outside the parliamentary groups (UFG).",
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

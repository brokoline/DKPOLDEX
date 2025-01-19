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
        val actorsByParty = actors.groupBy { actor -> extractPartyFromBiography(actor.biografi)?.trim()
            /*val partyName =
            when (partyName) {
                "Uden for folketingsgrupperne" -> "Løsgængere"
                else -> partyName
            }*/
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
            logoRes = R.drawable.moderaterne_logo,
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
            backColor =Color.White,
            policies = ""
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
            backColor =Color.White,
            policies = ""
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
            backColor =Color.White,
            policies = ""
        ),
        PartyData(
            name = "Socialistisk Folkeparti",
            path = "Socialistisk Folkeparti",
            logoRes = R.drawable.socialistiskfolkeparti,
            altLogo = R.drawable.socialistisk_folkeparti_logo,
            description = "Socialistisk Folkeparti was founded in 1959 by Aksel Larsen after a split from DKP, focusing on socialism and environmental policies.",
            history = "SF - Socialist People's Party (often simply SF in everyday speech; English: Green Left) is a Danish left-wing political party whose ideological foundation is built around socialism, specifically people's socialism, inspired by democratic socialism and green politics.\n" +
                    "\n" +
                    "The party was formed in 1959 by Aksel Larsen, a member excluded from the DKP, who believed that socialism should be introduced through democratic means and without dictates from the Soviet Union. Initially, the focus was largely on the economy and disarmament, but over the years, the party adopted several key issues such as the environment, education, gender equality, and human rights.\n" +
                    "\n" +
                    "SF has been a supporting party for various Social Democrat-led governments over time, starting with \"The Red Cabinet\" in 1966-67. In terms of voter support, the party has had three high points where it achieved more than 10% of the votes, followed by periods of decline: the first at the parliamentary election in 1966 under Aksel Larsen, the second during the 1980s with Gert Petersen as leader, and the third at the parliamentary election in 2007 under the relatively newly elected leader Villy Søvndal.\n" +
                    "\n" +
                    "Villy Søvndal worked diligently to make SF a governing party and succeeded when SF, together with the Social Democrats and the Danish Social Liberal Party, entered the Helle Thorning-Schmidt Government from 2011 to 2014. However, the government period was not a success for SF, as many members and voters felt that the party had abandoned its traditional policies. Villy Søvndal stepped down as leader in 2012, after which the relatively unknown parliamentary member Annette Vilhelmsen won a contested leadership election against the party leadership's candidate, Health Minister Astrid Krag. SF withdrew from the government in January 2014 following internal disagreements over the state's sale of part of DONG Energy, and Annette Vilhelmsen simultaneously resigned as leader and was succeeded by Pia Olsen Dyhr.\n" +
                    "\n" +
                    "In 2019, SF secured 14 seats in the Folketing and 2 members in the European Parliament.\n" +
                    "\n" +
                    "SF's youth organization is Socialistisk Folkepartis Ungdom, usually abbreviated as SFU.",
            website = "https://sf.dk",
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
            description = "Liberal Alliance was founded in 2007 and focuses on lower taxes, individual freedom, and less government regulation.",
            history = "Liberal Alliance (LA) is a Danish liberal-conservative party with 15 seats in the Folketing. The current leader is Alex Vanopslagh.\n" +
                    "\n" +
                    "Alex Vanopslagh, party leader from 2019 to present.\n" +
                    "\n" +
                    "The party originated from the center-right party Ny Alliance, which was formed in 2007, but soon after the parliamentary election, it split due to political disagreements and personal conflicts. Anders Samuelsen, who increasingly emerged as the party's strongman, led the transformation of the party into one with clear economic-liberalist viewpoints. The shift was completed with the name change to Liberal Alliance (LA) in August 2008 and the departure of the original leader Naser Khader from the party in January 2009, after which Anders Samuelsen took over as party leader.\n" +
                    "\n" +
                    "The party initially had only two members in the Folketing and seemed doomed with poor polling numbers, but with a program featuring clear key issues, the party gained ground and achieved nine and 13 seats in the parliamentary elections in 2011 and 2015, respectively. From 2016 to 2019, the party entered into the Lars Løkke Rasmussen III Government together with Venstre and the Conservatives. Liberal Alliance held six ministerial positions with Foreign Minister Anders Samuelsen at the helm. In the 2019 parliamentary election, Liberal Alliance lost nine seats, dropping to four seats with 2.3% of the vote. Anders Samuelsen lost his parliamentary seat and stepped down as party leader, with the newly elected Alex Vanopslagh taking over the position. In October 2019, the party was further reduced when the former group leader Simon Emil Ammitzbøll-Bille left the party. However, in the 2022 parliamentary election, the party achieved renewed success and its best result to date with 14 seats, partly due to a communication strategy that placed great emphasis on social media platforms like TikTok.\n" +
                    "\n" +
                    "The national chairman is Alex Vanopslagh. Liberal Alliance uses the party letter I, and its youth organization is called Liberal Alliance's Youth.",
            website = "https://liberalalliance.dk",
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
            description = "Dansk Folkeparti was founded in 1995 by Pia Kjærsgaard and has primarily focused on nationalism and immigration policies.",
            history = "Danish People's Party (DF) is a Danish political party founded in 1995 by Pia Kjærsgaard and three members who split from the Progress Party (Fremskridtspartiet). The party is characterized by its national-conservative, social-conservative, and right-populist ideology.\n" +
                    "\n" +
                    "From the beginning, DF distinguished itself by rejecting the Progress Party's ultraliberal and provocative elements, focusing instead on nationalism, strict immigration policies, and opposition to European integration. The party entered the Folketing with four members at its inception.\n" +
                    "\n" +
                    "In its first general election in 1998, DF secured 7.4% of the vote and 13 seats. The party continued to grow, achieving 12% and 22 seats in the 2001 elections, making it the third-largest party in the Folketing. DF played a supportive role in various center-right governments, helping to implement stricter immigration laws and other policy initiatives.\n" +
                    "\n" +
                    "Pia Kjærsgaard led the party until September 2012, when Kristian Thulesen Dahl took over. Under Thulesen Dahl's leadership, DF reached its peak in the 2015 election, obtaining 21.1% of the vote and 37 seats, becoming the largest party in the blue bloc. Despite this success, the party faced significant challenges in the following years, including scandals related to misuse of EU funds (MELD- and FELD-sag) and controversial cooperation with the Social Democrats, which led to a decline in support.\n" +
                    "\n" +
                    "In the 2019 European Parliament elections, DF lost three of its four seats, and the same trend continued in the 2019 general election, where it was reduced to 16 seats with 8.7% of the vote. Poor performance in the 2021 municipal elections prompted Kristian Thulesen Dahl to resign in January 2022. Morten Messerschmidt was elected as the new leader but faced further turmoil as 11 of the 16 Folketing members left the party to join the newly formed Denmark Democrats.\n" +
                    "\n" +
                    "In the 2022 general election, DF experienced its worst result to date, securing only 2.6% of the vote and five seats. The party remains known for its skepticism towards immigration and its defense of certain welfare state elements, positioning itself on the right side of the political spectrum.\n" +
                    "\n" +
                    "As of early 2023, DF is the ninth-largest party in the Folketing. The party's youth organization is Dansk Folkepartis Ungdom, and it is part of the Identity and Democracy group in the European Parliament. Morten Messerschmidt continues to lead the party, navigating ongoing challenges related to leadership and membership stability.",
            website = "https://danskfolkeparti.dk",
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
            name = "Danmarksdemokraterne",
            path = "Danmarksdemokraterne",
            logoRes = R.drawable.ddemkraterne,
            altLogo = R.drawable.danmarksdemokraterne_logo,
            description = "Danmarksdemokraterne was founded in 2022 by Inger Støjberg, focusing on national conservative values.",
            history = "Denmark Democrats (Danmarksdemokraterne) is a right-leaning political party in Denmark, founded in 2022 by Inger Støjberg, who also serves as the party leader. The party advocates for strict immigration policies and positions itself as a civil-oriented party within the traditional blue bloc. In its first parliamentary election in 2022, Denmark Democrats secured 14 seats, making it the second-largest party in the blue bloc. By March 2024, the party increased its representation to 16 seats, becoming the third-largest party in the Folketing. Additionally, in the 2024 European Parliament elections, the party won one seat.\n" +
                    "\n" +
                    "Inger Støjberg, the party's founder, was sentenced to 60 days of unconditional imprisonment on December 13, 2021, for violating the ministerial responsibility law. Previously, she served as the deputy leader and a member of Venstre but resigned from her deputy position in December 2020 and left the party entirely in February 2021. Following her conviction, Støjberg was deemed unfit to remain in the Folketing by a majority vote in December 2021. She served her sentence under house arrest in Hadsund from March 28, 2022, and was released on May 26, 2022. Upon her release, she held a thank-you event at Visborggaard Castle near Hadsund with approximately 2,000 attendees, where she expressed her continued passion for politics and hinted at announcing her political future, leading to speculation about the formation of a new party.\n" +
                    "\n" +
                    "Inger Støjberg remains the national chairman of Denmark Democrats. The party emphasizes a strict stance on immigration and seeks to influence Denmark's political landscape from the right side of the spectrum. Denmark Democrats continue to build their presence both nationally and in the European Parliament, navigating the challenges of establishing a new political force in Denmark's dynamic political environment.",
            website = "https://danmarksdemokraterne.dk",
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
            description = "Enhedslisten was founded in 1989 as a coalition of left-wing parties, focusing on equality and environmental protection.",
            history = "The Red-Green Alliance (Enhedslisten) is a Danish left-wing political party established in 1989 through the merger of the Left Socialists (Venstresocialisterne), Communist Party of Denmark (DKP), and the Socialist Workers Party (SAP). The party identifies with democratic socialism, eco-socialism, and feminism, advocating for extensive social welfare programs, environmental sustainability, and gender equality.\n" +
                    "\n" +
                    "Enhedslisten was formed as a unification of various leftist factions aiming to create a stronger, more cohesive political force in Denmark's parliament, the Folketing. The merger sought to consolidate efforts to address issues such as workers' rights, social justice, and opposition to neoliberal economic policies.\n" +
                    "\n" +
                    "In its early years, Enhedslisten focused on grassroots activism and building a broad base of support among workers, students, and marginalized communities. The party has consistently pushed for progressive policies, including the expansion of public services, increased taxation on the wealthy, and robust environmental protections to combat climate change.\n" +
                    "\n" +
                    "Enhedslisten has gradually increased its representation in the Folketing, becoming a significant voice for the left. The party emphasizes direct democracy, participatory decision-making, and solidarity with international socialist movements. It has also been active in promoting anti-racist initiatives and advocating for the rights of immigrants and refugees.\n" +
                    "\n" +
                    "As of early 2025, Enhedslisten holds a notable number of seats in the Folketing, positioning itself as a key player in shaping Denmark's progressive agenda. The party continues to advocate for comprehensive climate policies, enhanced social welfare systems, and the dismantling of capitalist structures that it views as inherently exploitative. Enhedslisten remains committed to fostering an inclusive and equitable society through its unwavering dedication to socialist principles and environmental sustainability.\n" +
                    "\n" +
                    "Enhedslisten operates with a strong emphasis on internal democracy, allowing members to have significant input into the party's policies and leadership decisions. The party's youth wing, Rød Ungdom (Red Youth), actively engages younger generations in political activism and advocacy, ensuring the continuity of the party's values and objectives.",
            website = "https://enhedslisten.dk",
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
            description = "Alternativet was founded in 2013 focusing on sustainability, green policies, and rethinking democracy.",
            history = "The Alternative (Alternativet) is a Danish green and progressive political party founded in 2013 by Josephine Fock and other activists. The party focuses on sustainability, social innovation, and fostering a green economy, positioning itself as a forward-thinking alternative to traditional political parties. Alternativet advocates for comprehensive climate policies, social justice, and participatory democracy, aiming to address contemporary societal challenges through innovative solutions.\n" +
                    "\n" +
                    "Since its establishment, The Alternative has experienced varying levels of electoral success, securing seats in the Folketing in the 2015 general election and maintaining representation in subsequent elections. The party has been involved in coalition discussions but has not been a major governing force. It appeals primarily to environmentally conscious voters, young people, and those seeking new approaches to politics and governance.\n" +
                    "\n" +
                    "As of early 2025, The Alternative continues to promote its agenda within the Folketing, emphasizing environmental sustainability, economic reform, and social equity. The party actively engages its youth wing, Alternative Youth, to involve younger generations in political activism and to sustain its progressive initiatives.",
            website = "https://alternativet.dk",
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
            name = "Sambandsflokkurin",
            path = "Sambandsflokkurin",
            logoRes = R.drawable.sambands,
            altLogo = R.drawable.sambandsflokkurin_logo,
            description = "Sambandsflokkurin is a Faroese party founded in 1906 focusing on union with Denmark.",
            history = "Sambandsflokkurin, also known as the Union Party, is a major political party in the Faroe Islands founded in 1930. The party advocates for maintaining and strengthening the union between the Faroe Islands and the Kingdom of Denmark. Sambandsflokkurin promotes policies that support economic stability, fisheries management, and the preservation of Faroese culture and language. Historically, the party has been influential in Faroese politics, often holding a significant number of seats in the Løgting, the Faroese Parliament. Sambandsflokkurin has participated in various coalition governments, emphasizing cooperation with other parties to achieve its objectives. The party appeals to voters who favor close ties with Denmark while seeking greater autonomy for the Faroe Islands. Leadership has been marked by experienced politicians who prioritize pragmatic solutions to economic and social issues facing the islands. Sambandsflokkurin continues to play a pivotal role in shaping the political landscape of the Faroe Islands, balancing the interests of maintaining the union with Denmark and addressing local concerns.",
            website = "https://samband.fo",
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
            name = "Javnaðarflokkurin",
            path = "Javnaðarflokkurin",
            logoRes = R.drawable.javna,
            altLogo = R.drawable.javna,
            description = "Javnaðarflokkurin is a Faroese social democratic party founded in 1925 focusing on equality and welfare.",
            history = "Javnaðarflokkurin (The Social Democratic Party) is a major political party in the Faroe Islands, founded in 1935. The party advocates for social democracy, emphasizing welfare state principles, workers' rights, and equitable economic policies. Javnaðarflokkurin supports maintaining strong ties with the Kingdom of Denmark while also promoting Faroese autonomy and the preservation of Faroese culture and language.\n" +
                    "\n" +
                    "Throughout its history, Javnaðarflokkurin has been influential in Faroese politics, frequently securing a significant number of seats in the Løgting, the Faroese Parliament. The party has participated in various coalition governments, often collaborating with other center-left and social democratic parties to implement progressive policies aimed at improving social services, education, and healthcare in the Faroe Islands.\n" +
                    "\n" +
                    "Javnaðarflokkurin appeals to voters who prioritize social equality, economic stability, and the protection of Faroese interests within the broader framework of the Danish Realm. The party is known for its pragmatic approach to governance, balancing the need for social reforms with economic sustainability. Under the leadership of experienced politicians, Javnaðarflokkurin continues to play a pivotal role in shaping the political landscape of the Faroe Islands, striving to enhance the quality of life for its citizens through comprehensive social policies and responsible economic management.\n" +
                    "\n" +
                    "As of early 2025, Javnaðarflokkurin remains one of the leading parties in the Løgting, actively contributing to legislative processes and government formation. The party continues to advocate for policies that support social welfare, sustainable economic development, and the safeguarding of Faroese cultural heritage. Javnaðarflokkurin maintains a strong grassroots presence, engaging with communities across the islands to address local concerns and ensure inclusive representation in the political arena.",
            website = "https://j.fo",
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
            description = "Siumut is a Greenlandic social democratic party founded in 1977, focusing on self-governance and indigenous rights.",
            history = "Siumut (meaning \"Forward\") is a major social-democratic political party in Greenland, founded in 1977. The party advocates for Greenlandic self-government, social welfare policies, and economic development, while maintaining strong ties with Denmark. Siumut has been a dominant force in Greenlandic politics since the establishment of home rule, frequently leading the government and providing several Prime Ministers, including Jonathan Motzfeldt, Lars Emil Johansen, Hans Enoksen, Kuupik Kleist, and Aleqa Hammond.\n" +
                    "\n" +
                    "The party focuses on issues such as education, healthcare, sustainable fisheries, and infrastructure development, aiming to improve the quality of life for Greenland's residents. Siumut traditionally garners support from urban areas and has maintained a significant presence in the Inatsisartut, Greenland's parliament. As of early 2025, Siumut continues to play a key role in shaping Greenland's political landscape, advocating for policies that balance economic growth with social equity and environmental sustainability.",
            website = "https://siumut.gl",
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
            description = "Inuit Ataqatigiit is a Greenlandic left-wing party founded in 1976 focusing on independence and environmental protection.",
            history = "Inuit Ataqatigiit is a left-wing political party in Greenland, founded in 1978. The party advocates for Greenlandic independence, social democracy, environmental sustainability, and the protection of Inuit culture and traditions. Inuit Ataqatigiit emphasizes the importance of sustainable development, focusing on issues such as renewable energy, fisheries management, and combating climate change to ensure the long-term well-being of Greenland's population and environment.\n" +
                    "\n" +
                    "Since its establishment, Inuit Ataqatigiit has been a significant force in Greenlandic politics, frequently securing a substantial number of seats in the Inatsisartut, Greenland's parliament. The party has led the government multiple times, with notable Prime Ministers including Josef Motzfeldt, Kuupik Kleist, and Múte Bourup Egede. Inuit Ataqatigiit has been instrumental in pushing for policies that promote social welfare, education, healthcare, and economic diversification to reduce Greenland's reliance on fishing and mineral resources.\n" +
                    "\n" +
                    "The party attracts voters who are passionate about social equality, environmental protection, and greater autonomy for Greenland within the Kingdom of Denmark. Inuit Ataqatigiit is known for its progressive stance on social issues, including gender equality and the rights of indigenous peoples. As of early 2025, Inuit Ataqatigiit continues to play a pivotal role in shaping Greenland's political landscape, advocating for policies that balance economic growth with social justice and environmental responsibility.\n" +
                    "\n" +
                    "Inuit Ataqatigiit remains one of the leading parties in the Inatsisartut, actively participating in government formation and legislative processes. The party continues to champion initiatives aimed at achieving greater self-governance for Greenland, enhancing social services, and promoting sustainable environmental practices. With a strong grassroots presence, Inuit Ataqatigiit engages with communities across Greenland to address local concerns and ensure that its policies reflect the needs and aspirations of the Inuit population.",
            website = "https://ia.gl",
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
            path = "Uden for folketingsgrupperne",
            logoRes = R.drawable.loes,
            altLogo = R.drawable.loesgaengere,
            description = "An independent (løsgænger) is a member of the Danish Parliament who does not belong to any of the party groups in the Danish Parliament. An independent is called outside the parliamentary groups (UFG).",
            history = "An independent, known in Danish as a \"løsgænger,\" is an elected representative who does not belong to any political party or group. Typically, individuals become independents by resigning from or being expelled from their party during their term. Since the 1953 Constitution, only Jacob Haugaard was elected to the Folketing as an independent following the 1994 election, aside from Hans Schmidt in 1953, who was technically elected as an independent while representing the Schleswig Party.\n" +
                    "\n" +
                    "Independents are more common in local politics than in the Folketing because party structures play a significant role in providing support and expertise to members, making it challenging for individuals to cover all political areas on their own. Officially, elected representatives are not referred to as independents but as being outside of parties, abbreviated in the Folketing as UFG (udenfor folketingsgrupperne). The term \"løsgænger\" is somewhat humorous, originally referring to someone without a fixed residence or occupation. Historically, being an independent was punishable by law.\n" +
                    "\n" +
                    "In the European Parliament, there are several independents who may be members of national parties but do not join other parliamentarians in a group.",
            website = "https://www.ft.dk/da/ofte-stillede-spoergsmaal/medl_hvad-er-en-loesgaenger",
            backgroundColor = SocialdemokratietBackground,
            cardColor = altSocialdemokratiet,
            buttonColor = SocialdemokratietButton,
            offsetX = 10f,
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
}

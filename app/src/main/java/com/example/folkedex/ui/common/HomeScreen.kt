package com.example.folkedex.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun HomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .consumeWindowInsets(WindowInsets.systemBars)

    ) {
        TopSectionWithSearchBar()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 230.dp)
                .background(color = Color.White)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            PoliticianCategoryGrid(navController)
        }
    }
}


@Composable
fun TopSectionWithSearchBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color(0xFFFF6F61))
            .padding(16.dp)
            .windowInsetsPadding(WindowInsets.systemBars.only(WindowInsetsSides.Bottom))
    ) {

        FolketingLogo(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(x = -50.dp)
                .offset(y = -5.dp)
                .size(200.dp)
                .zIndex(0f)
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Welcome to FolkeDex!",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Your go-to political hub",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            var searchQuery = ""
            SearchBar(value = searchQuery,
                onValueChange = { searchQuery  = it })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        },
        placeholder = {
            Text(text = "Search for Politician, Party, etc...")
        },
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF5F5F5),
            unfocusedContainerColor = Color(0xFFF5F5F5),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            cursorColor = Color.Black
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
}

@Composable
fun PoliticianCategoryGrid(navController: NavHostController) {
    val categories = listOf(
        "FolkeDex" to Pair(Color(0xFFFF6E60), Color(0xFFFFB1A5)),
        "Reports" to Pair(Color(0xFF6B9F39), Color(0xFFAED582)),
        //"Issues" to Pair(Color(0xFF722424), Color(0xFFEAAFAF)),
        "News" to Pair(Color(0xFFFFCE4B), Color(0xFFFFE49A))
        //"Bills" to Pair(Color(0xFF0A9180), Color(0xFF73C4BB)),
        //"Data" to Pair(Color(0xFF2C4F80), Color(0xFF4D8BDE))
    )

    Column(
        //verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        categories.chunked(1).forEach { rowCategories ->
            Row(
                //horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                rowCategories.forEach { (text, color) ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(2.5f)
                    ) {
                        CategoryCard(
                            text = text,
                            startColor = color.first,
                            endColor = color.second,
                            onClick = {
                                when (text) {
                                    "FolkeDex" -> navController.navigate("folkedex")
                                    //"Issues" -> navController.navigate("com/example/folkedex/ui/issues")
                                    "Reports" -> navController.navigate("reports")
                                    //"Bills" -> navController.navigate("testapi")
                                    "News" -> navController.navigate("com/example/folkedex/ui/news")
                                    //"Data" -> navController.navigate("com/example/folkedex/data")

                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryCard(text: String, startColor: Color, endColor: Color, onClick: () -> Unit) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp

    Box(
        modifier = Modifier
            .fillMaxSize(), // Ensures the Box fills the entire available space
        contentAlignment = Alignment.Center // Aligns content (Card) to the center
    ) {
        Card(
            modifier = Modifier
                .height((screenHeight / 6).dp)
                .width((screenWidth / 1.5).dp)
                .shadow(8.dp, shape = RoundedCornerShape(16.dp))
                .clickable { onClick() },
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                startColor,
                                endColor
                            )
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = text,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }


    /*@Preview(
        showSystemUi = true,
        showBackground = true,
        device = "spec:width=411dp,height=891dp,dpi=420"
    )*/
    @Composable
    fun PreviewHomeScreen() {
        val navController = rememberNavController()
        HomeScreen(navController = navController)
    }
}
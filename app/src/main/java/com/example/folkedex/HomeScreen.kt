package com.example.folkedex

import androidx.compose.foundation.Image
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    Column {
        TopSectionWithSearchBar()
        Spacer(modifier = Modifier.height(16.dp))
        PoliticianCategoryGrid(navController)
    }
}

@Composable
fun TopSectionWithSearchBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp) // Fixed height for red background area
            .background(Color(0xFFFF6F61)) // Red color
            .padding(16.dp)
    ) {
        // Logo as faint background
        Image(
            painter = painterResource(id = R.drawable.flogo),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.49f) //Logo size background above
                .align(Alignment.Center),
            contentScale = ContentScale.FillWidth
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
            SearchBar()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    TextField(
        value = "",
        onValueChange = { /* for search bar input, backend thing */ },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
        },
        placeholder = { Text("Search for Politician, Party, etc...") },
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xFFF5F5F5),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
}

@Composable
fun PoliticianCategoryGrid(navController: NavHostController) {
    val categories = listOf(
        "FolkeDex" to Pair(Color(0xFFFF6E60), Color(0xFFFFB1A5)),
        "Reports" to Pair(Color(0xFF6B9F39), Color(0xFFAED582)),
        "Issues" to Pair(Color(0xFF722424), Color(0xFFEAAFAF)),
        "News" to Pair(Color(0xFFFFCE4B), Color(0xFFFFE49A)),
        "Bills" to Pair(Color(0xFF0A9180), Color(0xFF73C4BB)),
        "Data" to Pair(Color(0xFF2C4F80), Color(0xFF4D8BDE))
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(40.dp), //vertical distance between categories
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        categories.chunked(2).forEach { rowCategories ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp), //horizontal distance between categories
                modifier = Modifier.fillMaxWidth()
            ) {
                rowCategories.forEach { (text, color) ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1.5f)
                    ) {
                        CategoryCard(
                            text = text,
                            startColor = color.first,
                            endColor = color.second,
                            onClick = {
                                when (text) {
                                    "FolkeDex" -> navController.navigate("folkedex")
                                    "Issues" -> navController.navigate("issues")
                                    "Reports" -> navController.navigate("reports")
                                    "Bills" -> navController.navigate("bills")
                                    "News" -> navController.navigate("news")
                                    // other routes here
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
    Card(
        modifier = Modifier
            .fillMaxSize()
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
                )
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = text,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 22.sp
                )
                Image(
                    painter = painterResource(id = R.drawable.flogo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(75.dp)
                        .alpha(0.5f)

                )
            }
        }
    }
}

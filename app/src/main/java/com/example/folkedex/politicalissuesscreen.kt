package com.example.folkedex.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.folkedex.R

class PoliticalIssuesScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PoliticalIssuesScreen(onIssueClick = { /* Handle issue selection */ })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PoliticalIssuesScreen(onIssueClick: (String) -> Unit) {
    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF8E5355))
                    .padding(bottom = 8.dp) // Padding to move the title lower
            ) {
                TopAppBar(
                    title = {
                        Text(
                            text = "Political issues",
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp
                            ),
                            color = Color.White,
                            modifier = Modifier.padding(start = 16.dp) // Add some padding to align nicely
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { /* Handle back button click */ }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF8E5355))
                )
                SearchBar() // Search bar integrated below the top app bar with adjustments
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                val issues = listOf(
                    "Environment and climate",
                    "Economy and labor market",
                    "Health and welfare",
                    "Human rights and equality"
                )
                issues.forEach { issue ->
                    IssueButton(issue, onIssueClick)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    TextField(
        value = "",
        onValueChange = { /* Handle search query changes */ },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search icon"
            )
        },
        placeholder = {
            Text("Search for specific issues...")
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(color = Color(0xFFE0B7B8), shape = RoundedCornerShape(16.dp)), // Added rounded corners and background color
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(16.dp) // Rounded corners for the search bar
    )
}

@Composable
fun IssueButton(issue: String, onClick: (String) -> Unit) {
    Button(
        onClick = { onClick(issue) },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFAE7071)),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Text(
            text = issue,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewPoliticalIssuesScreen() {
    PoliticalIssuesScreen(onIssueClick = { /* Handle click */ })
}

package com.example.folkedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

class PoliticalIssuesScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PoliticalIssuesScreenUnique(onIssueClick = { /* Handle issue selection */ })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PoliticalIssuesScreenUnique(onIssueClick: (String) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Political issues",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        ),
                        color = Color.White
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
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
                    .background(Color(0xFF8E5355)),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SearchBarUnique()
                Spacer(modifier = Modifier.height(16.dp))
                val issues = listOf(
                    "Environment and Climate",
                    "Economy and Labor Market",
                    "Health and Welfare",
                    "Human Rights and Equality"
                )
                issues.forEach { issue ->
                    IssueButtonUnique(issue, onIssueClick)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarUnique() {
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
            .height(56.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xFFE0B7B8),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun IssueButtonUnique(issue: String, onClick: (String) -> Unit) {
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
fun PreviewPoliticalIssuesScreenUnique() {
    PoliticalIssuesScreenUnique(onIssueClick = { /* Handle click */ })
}

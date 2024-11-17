package com.example.folkedex.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.folkedex.R


data class Data(val title: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataScreen(onBackClick: () -> Unit = {}) {
    // Dummy data untill we connect to the API
    val examples = listOf(
        Data(title = "Data Example"),
        Data(title = "Data Example"),
        Data(title = "Data Example"),
        Data(title = "Data Example")
    )

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color(0xFF3A6AA9)),
                contentAlignment = Alignment.CenterStart
            ) {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .align(Alignment.CenterStart)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Tilbage",
                        tint = Color.White
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.database),
                        contentDescription = "News Icon",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(bottom = 4.dp)
                    )

                    Text(
                        "Data",
                        fontSize = 30.sp,
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )


                }

                FolketingLogo(modifier = Modifier.align(Alignment.CenterEnd))
            }
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 26.dp)
                    .padding(vertical = 26.dp)
            ) {
                items(examples) { data ->
                    DataCard(
                        data = data,
                    )
                }
            }
        }
    )
}

// Preview for ReportsScreen
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewDataScreen() {
    DataScreen()
}
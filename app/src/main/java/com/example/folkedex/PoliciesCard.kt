package com.example.folkedex.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PoliciesScreen(onBackClick: () -> Unit = {}, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE1BEE7)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top bar with attributed title "Policies"
        TopAppBar(
            title = {
                Text(
                    text = "Policies",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            },
            navigationIcon = {
                IconButton(onClick = {navController.popBackStack()}) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFFAB47BC))
        )

        // Party logo
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = android.R.drawable.ic_menu_gallery),
            contentDescription = "Moderaterne Logo",
            modifier = Modifier
                .size(100.dp)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Title and content section
        Text(
            text = "FORANDRING FRA MIDTEN",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Denmark is a wonderful country. A great place to grow up, start a family and grow old. In a lot of ways we've discovered the recipe for a society with a good balance between equality, freedom og security. That is the 'sunny' side of the story of Denmark.\n\nBut - hand on the heart - there's also a shadow-side:",
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "- Too many young people builds up professional skills and personal robustness to gain foothold in the work-environment\n- Too many ideas and initiatives aren’t translated into job-opportunities and prosperity\n- Too many elderly aren’t treated with care and worth\n- Too many people live on the edge of society without being an active part of the community\n- Too many people of different ethnical origin than Danish aren’t able to fully participate in society.",
            fontSize = 14.sp,
            color = Color.White,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Bottom clickable sections
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .background(Color(0xFFD1C4E9))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Political Proposals", color = Color.Black, fontWeight = FontWeight.Bold)
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .background(Color(0xFFD1C4E9))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Values & Thoughts", color = Color.Black, fontWeight = FontWeight.Bold)
            }
        }
    }
}



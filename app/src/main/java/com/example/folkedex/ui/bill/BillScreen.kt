package com.example.folkedex.ui.bill

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.folkedex.ui.common.FolketingLogo


@Composable
fun BillScreen( navController: NavController) {

    val votes = listOf(
        Vote(title = "Proposal A", description = "Passed with majority votes"),
        Vote(title = "Proposal B", description = "Rejected due to lack of support"),
        Vote(title = "Proposal C", description = "Passed unanimously")
    )

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(Color(0xFF0D9180)),
                contentAlignment = Alignment.CenterStart
            ) {
                IconButton(
                    onClick = {navController.popBackStack()},
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
                FolketingLogo(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset(x = -50.dp)
                        .offset(y = -25.dp)
                        .size(200.dp)
                        .zIndex(0f)
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Votes Icon",
                        tint = Color.White,
                        modifier = Modifier
                            .size(100.dp)
                            .padding(bottom = 4.dp)
                    )
                    Text(
                        "Bills",
                        fontSize = 30.sp,
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )
                    var searchQuery = ""
//                    com.example.folkedex.ui.common.SearchBar(
//
//                        modifier = Modifier
//                            .padding(horizontal = 15.dp), value="", onValueChange =
//                        { searchQuery  = it }
//                )

                }
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
                items(votes) { vote ->
                    VoteCard(vote = vote, onClick = { /* whatever click logic */ })
                }
            }
        }
    )
}
@Preview(
    showSystemUi = true,
    showBackground = true,
    device = "spec:width=411dp,height=891dp,dpi=420"
)
@Composable
fun PreviewBillsScreen() {
    val navController = rememberNavController()
    BillScreen(navController = navController)
}
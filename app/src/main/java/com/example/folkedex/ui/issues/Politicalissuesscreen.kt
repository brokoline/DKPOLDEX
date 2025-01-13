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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.folkedex.R // Importerer drawable ressourcer

@Composable
fun IssuesScreen(onBackClick: () -> Unit = {}, navController: NavController) {
    val issues = listOf(
        Issue(title = "Mental Health"),
        Issue(title = "Immigration Policies"),
        Issue(title = "Freedom of Movement"),
    )

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(Color(0xFF722424)),
                contentAlignment = Alignment.CenterStart
            ) {
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .align(Alignment.CenterStart)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
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
                    Image(
                        painter = painterResource(id = R.drawable.exclamation_mark),
                        contentDescription = "Exclamation Icon",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(bottom = 4.dp)
                            .padding(top = 10.dp),
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                    Text(
                        "Political Issues",
                        fontSize = 30.sp,
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )
                    com.example.folkedex.ui.common.SearchBar(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                    )
                }
            }
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            ) {
                items(issues) { issue ->
                    IssuesCard(issue = issue, onClick = {/*random*/})
                }
            }
        }
    )
}

@Composable
fun GradientButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.White
        ),
        contentPadding = PaddingValues()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF722424),
                            Color(0xFFEAAFAF)
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    device = "spec:width=411dp,height=891dp,dpi=420"
)
@Composable
fun PreviewIssuesScreen() {
    val navController = rememberNavController()
    IssuesScreen(navController = navController)
}
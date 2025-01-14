package com.example.folkedex.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

data class Issue(val title: String)

@Composable
fun IssuesCard(issue: Issue, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(16.dp))
            .height(75.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF722424 ), Color(0xFFEAAFAF)) // Nyt gradient for afstemninger
                    )
                )
                .padding(16.dp)
        ) {
            Column {
                Text(
                    text = issue.title,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
            }
        }
    }
}

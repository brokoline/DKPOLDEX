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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.folkedex.R

data class Meeting(val number: Int, val title: String, val date: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeetingsScreen(onBackClick: () -> Unit = {}, onMeetingClick: (String) -> Unit = {}) {
    // Dummy-data til news
    val meetings = listOf(
        Meeting(number = 19, title = "Report of meeting 19 on November 14, 2024 at 10:00 AM", date = "14-11-2024 (2024-25)"),
        Meeting(number = 18, title = "Report of meeting 18 on November 13, 2024 at 1:00 PM", date = "13-11-2024 (2024-25)"),
        Meeting(number = 17, title = "Report of meeting 17 on November 12, 2024 at 1:00 PM", date = "12-11-2024 (2024-25)"),
        Meeting(number = 16, title = "Report of meeting 16 on November 8, 2024 at 9:00 AM", date = "08-11-2024 (2024-25)"),
    )


    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color(0xFFF7C72E)), // Gult tema
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
                        painter = painterResource(id = R.drawable.newsicon), // Bruger dit nye ikon
                        contentDescription = "News Icon",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(bottom = 4.dp)
                    )
                    Text(
                        "News",
                        fontSize = 30.sp,
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )
                }

                // bruger det eksisterende FolketingLogo-objekt
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
                items(meetings) { meeting ->
                    MeetingCard(meeting = meeting, onClick = { onMeetingClick(meeting.title) })
                }
            }
        }
    )
}

@Composable
fun MeetingCard(meeting: Meeting, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF5E660) // Gule bokse
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Møde nr. ${meeting.number}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = meeting.title,
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 4.dp)
            )
            Text(
                text = "Dato: ${meeting.date}",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 4.dp)
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
fun PreviewMeetingsScreen() {
    MeetingsScreen()
}

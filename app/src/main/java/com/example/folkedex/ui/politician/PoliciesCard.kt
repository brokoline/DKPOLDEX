package com.example.folkedex.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.folkedex.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PoliciesCard() {
    val navController = rememberNavController()

    Column(
        modifier = Modifier
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(0.dp))
        Image(
            painter = painterResource(id = R.drawable.moderaterne3),
            contentDescription = "Moderaterne Logo",
            modifier = Modifier
                .width(230.dp)
                .height(70.dp)
                .padding(16.dp)
        )


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF9C27B0), Color(0xFFE1BEE7))
                    )
                )
                .padding(6.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "FORANDRING FRA MIDTEN",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 8.dp),
                )
                Text(
                    text = "Denmark is a wonderful country. A great place to grow up, start a family and grow old. In a lot of ways we've discovered the recipe for a society with a good balance between equality, freedom og security. That is the 'sunny' side of the story of Denmark.\n\n",
                    fontSize = 14.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                )
                Text(
                    text = "But - hand on the heart - there's also a shadow-side:",
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 8.dp)
                )
                Text(
                    text = "- Too many young people builds up professional skills and personal robustness to gain foothold in the work-environment\n- Too many ideas and initiatives aren’t translated into job-opportunities and prosperity\n- Too many elderly aren’t treated with care and worth\n- Too many people live on the edge of society without being an active part of the community\n- Too many people of different ethnical origin than Danish aren’t able to fully participate in society.",
                    fontSize = 14.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                )
            }
        }

        //Spacer(modifier = Modifier.height(16.dp))


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 64.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .border(width = 6.dp, color = Color(0xFFAB47BC), shape = RoundedCornerShape(8.dp))
                    .clip(RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.forslag),
                        contentDescription = "Political Proposals Image",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp))
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.BottomCenter)
                    ) {
                        Text(
                            text = "Political Proposals",
                            fontSize = 12.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(Alignment.BottomCenter)
                                .height(48.dp)
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .background(Color.Transparent)
                    .border(width = 6.dp, color = Color(0xFFAB47BC), shape = RoundedCornerShape(8.dp))
                    .clip(RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.vaerdier),
                        contentDescription = "Values & Thoughts Image",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp))
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.BottomCenter)
                    ) {
                        Text(
                            text = "Values & Thoughts",
                            fontSize = 12.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(Alignment.BottomCenter)
                                .height(48.dp)
                        )
                    }
                }
            }
        }
    }
}





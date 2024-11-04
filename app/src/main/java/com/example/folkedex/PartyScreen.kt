package com.example.folkedex.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.folkedex.R


@OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Party(onBackClick: () -> Unit = {}) {
        Scaffold(
            topBar = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(Color(0xFF842990)),
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

                    // Moderaterne logo
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.offset(x = (100).dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.moderaterne),
                            contentDescription = "Centered Image",
                            modifier = Modifier
                                .size(120.dp)
                                .padding(bottom = 4.dp)
                        )
                        Text(
                            "Moderaterne",
                            fontSize = 40.sp,
                            color = Color.White,
                            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                        )
                    }

                    // folketing logo
                    Image(
                        painter = painterResource(id = R.drawable.flogo),
                        contentDescription = "Right Aligned Transparent Image",
                        modifier = Modifier
                            .size(300.dp)
                            .align(Alignment.CenterEnd)
                            .padding(end = 16.dp)
                            .offset(x = (100).dp, y = (-40).dp) // moving text
                            .alpha(0.4f) //  transparency
                    )
                }
            },
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // text about the party
                    Text(
                        text = "Text about the Moderaterne party, \n" +
                                "eventually what they stand for,\n" +
                                "political orientation/spectrum\n" +
                                "placement, when they were founded,\n" +
                                "etc etc.",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )

                    // Button layout
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(32.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            CustomButton(text = "Politicians", imageRes = R.drawable.flogo, modifier = Modifier.width(170.dp))
                            CustomButton(text = "History", imageRes = R.drawable.flogo, modifier = Modifier.width(170.dp))
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            CustomButton(text = "Policies", imageRes = R.drawable.flogo, modifier = Modifier.width(170.dp))
                            CustomButton(text = "Statistics", imageRes = R.drawable.flogo, modifier = Modifier.width(170.dp))
                        }
                    }
                }
            }
        )
    }

    @Composable
    fun CustomButton(text: String, imageRes: Int, modifier: Modifier = Modifier) {

        Button(
            onClick = { /* Handle click */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9F5BBA)),
            shape = RoundedCornerShape(10.dp),
            modifier = modifier
                .shadow(elevation = 10.dp, shape = RoundedCornerShape(20.dp), clip = true)
                .height(60.dp),

            contentPadding = PaddingValues(horizontal = 16.dp),
            
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = text,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "Button Icon",
                    modifier = Modifier.size(42.dp)
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
    fun PreviewParty() {
        Party()
    }



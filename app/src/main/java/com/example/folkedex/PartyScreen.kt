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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import com.example.folkedex.R



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Party(partyData: PartyData, onBackClick: () -> Unit = {}, navController: NavHostController) {
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(partyData.backgroundColor),
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
                        contentDescription = "Back",

                        tint = partyData.backColor
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.offset(x = partyData.offsetX.dp, y = partyData.offsetY.dp)
                ) {
                    Image(
                        painter = painterResource(id = partyData.logoRes),
                        contentDescription = "Centered Image",
                        modifier = Modifier
                            .size(partyData.imageSize)
                            .padding(bottom = 4.dp)
                    )
                    Text(
                        partyData.name,
                        fontSize = partyData.textSize,
                        color = partyData.backColor,
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )
                }

                FolketingLogo(modifier = Modifier.align(Alignment.CenterEnd))
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
                Text(
                    text = partyData.description,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(32.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        CustomButton(
                            text = "Politicians",
                            textColor = partyData.backColor,
                            imageRes = R.drawable.flogo,
                            buttonColor = partyData.buttonColor,
                            modifier = Modifier.width(170.dp),
                            onClick = { }
                        )
                        CustomButton(
                            text = "History",
                            textColor = partyData.backColor,
                            imageRes = R.drawable.flogo,
                            buttonColor = partyData.buttonColor,
                            modifier = Modifier.width(170.dp),
                            onClick = {navController.navigate("history")  }
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        CustomButton(
                            text = "Policies",
                            textColor = partyData.backColor,
                            imageRes = R.drawable.flogo,
                            buttonColor = partyData.buttonColor,
                            modifier = Modifier.width(170.dp),
                            onClick = { }
                        )
                        CustomButton(
                            text = "Statistics",
                            textColor = partyData.backColor,
                            imageRes = R.drawable.flogo,
                            buttonColor = partyData.buttonColor,
                            modifier = Modifier.width(170.dp),
                            onClick = { }
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun CustomButton(text: String, imageRes: Int, buttonColor: Color, textColor: Color, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
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
                color = textColor,
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


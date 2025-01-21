package com.example.folkedex.ui.party

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.folkedex.model.PartyData
import com.example.folkedex.ui.common.FolketingLogo


@Composable
fun Party(partyData: PartyData, navController: NavHostController) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(partyData.backgroundColor),
                contentAlignment = Alignment.CenterStart
            ) {
                FolketingLogo(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset(x = -50.dp)
                        .offset(y = -5.dp)
                        .size(200.dp)
                        .zIndex(0f)
                )
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.padding(start = 16.dp)
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
                        modifier = Modifier.size(partyData.imageSize).padding(bottom = 4.dp)
                    )
                    Text(
                        partyData.path,
                        fontSize = partyData.textSize,
                        color = partyData.backColor,
                        style = androidx.compose.material3.MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )
                }
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = partyData.description,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Visit Party Website",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = partyData.buttonColor,
                    modifier = Modifier
                        .clickable {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(partyData.website))
                            context.startActivity(intent)
                        }
                        .padding(top = 24.dp)
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(24.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        CustomButton(
                            text = "Politicians",
                            textColor = partyData.backColor,
                            buttonColor = partyData.buttonColor,
                            onClick = { navController.navigate("politicians/${partyData.name}")},
                            modifier = Modifier.weight(1f).padding(8.dp),
                            partyData = partyData,
                            navController = navController,
                        )
                        CustomButton(
                            text = "History",
                            textColor = partyData.backColor,
                            buttonColor = partyData.buttonColor,
                            modifier = Modifier.weight(1f).padding(8.dp),
                            partyData = partyData,
                            navController = navController,
                            onClick = { navController.navigate("com/example/folkedex/ui/history/${partyData.path}") }
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        CustomButton(
                            text = "Policies",
                            textColor = partyData.backColor,
                            buttonColor = partyData.buttonColor,
                            onClick = { navController.navigate("policies/${partyData.name}") },
                            modifier = Modifier.weight(1f).padding(8.dp),
                            partyData = partyData,
                            navController = navController,
                        )
                        CustomButton(
                            text = "Statistics",
                            textColor = partyData.backColor,
                            buttonColor = partyData.buttonColor,
                            modifier = Modifier.weight(1f).padding(8.dp),
                            partyData = partyData,
                            navController = navController,
                            onClick = { }
                        )
                    }
                }
            }
        }
    )
}


@Composable
fun CustomButton(
    text: String,
    buttonColor: Color,
    textColor: Color,
    modifier: Modifier = Modifier,
    partyData: PartyData,
    navController: NavHostController,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .shadow(elevation = 10.dp, shape = RoundedCornerShape(20.dp), clip = true)
            .height(60.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
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
        }
    }
}

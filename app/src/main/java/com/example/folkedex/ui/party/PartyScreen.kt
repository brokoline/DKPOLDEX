package com.example.folkedex.ui.party

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.folkedex.data.model.PartyData
import com.example.folkedex.ui.common.FolkeLogo


@Composable
fun Party(partyData: PartyData, navController: NavHostController) {
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(partyData.backgroundColor),
                contentAlignment = Alignment.CenterStart
            ) {
                FolkeLogo(partyData)

                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = partyData.backColor
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.weight(1.5f))
                    Image(
                        painter = painterResource(id = partyData.logoRes),
                        contentDescription = "Centered Image",
                        modifier = Modifier.size(partyData.imageSize).padding(bottom = 4.dp)
                    )
                    Text(
                        partyData.path,
                        fontSize = partyData.textSize,
                        color = partyData.backColor,
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                                modifier = Modifier
                                .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.weight(0.5f))
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
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CustomButton(
                        text = "Politicians",
                        buttonColor = Brush.linearGradient(
                            colors = listOf(partyData.buttonColor, partyData.gradeColor)
                        ),
                        textColor = partyData.backColor,
                        modifier = Modifier
                            .width((screenWidth / 2).dp)
                            .padding(vertical = 4.dp),
                        onClick = { navController.navigate("politicians/${partyData.name}") },
                    )
                    CustomButton(
                        text = "History",
                        buttonColor = Brush.linearGradient(
                            colors = listOf(partyData.buttonColor, partyData.gradeColor)
                        ),
                        textColor = partyData.backColor,
                        modifier = Modifier
                            .width((screenWidth / 2).dp)
                            .padding(vertical = 4.dp),
                        onClick = { navController.navigate("com/example/folkedex/ui/history/${partyData.path}") },
                    )
                    CustomButton(
                        text = "Policies",
                        buttonColor = Brush.linearGradient(
                            colors = listOf(partyData.buttonColor, partyData.gradeColor)
                        ),
                        textColor = partyData.backColor,
                        modifier = Modifier
                            .width((screenWidth / 2).dp)
                            .padding(vertical = 4.dp),
                        onClick = { navController.navigate("policies/${partyData.name}") },
                    )
                }
            }
        }
    )
}


@Composable
fun CustomButton(
    text: String,
    buttonColor: Brush,
    textColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .shadow(elevation = 10.dp, shape = RoundedCornerShape(20.dp), clip = true)
            .height(60.dp)
            .background(buttonColor, shape = RoundedCornerShape(10.dp))
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)
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

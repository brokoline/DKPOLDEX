package com.example.folkedex.ui.politician

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.folkedex.R

@Composable
fun PoliticianCard() {
    // Politician Image
    Image(
        painter = painterResource(id = R.drawable.politician_image), // Replace with your drawable
        contentDescription = "Politician Image",
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .clip(RoundedCornerShape(8.dp))
    )
}


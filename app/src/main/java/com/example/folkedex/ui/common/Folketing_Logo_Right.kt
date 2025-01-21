package com.example.folkedex.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.folkedex.R

@Composable
fun FolketingLogo(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.flogo3),
        contentDescription = "Folketing Logo",
        modifier = modifier
            .size(300.dp)
            .padding(end = 16.dp)
            .offset(x = 100.dp, y = (-40).dp)
            .alpha(1.0f)
    )
}
@Composable
fun FolketingLogoWhite(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.flogo_white),
        contentDescription = "Folketing Logo",
        modifier = modifier
            .size(300.dp)
            .padding(end = 16.dp)
            .offset(x = 100.dp, y = (-40).dp)
            .alpha(1.0f)
    )
}

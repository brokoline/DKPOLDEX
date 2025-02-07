package com.example.folkedex.data.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class PartyData(
    val name: String,
    val structuredName: String,
    val path: String,
    @DrawableRes val logoRes: Int,
    @DrawableRes val altLogo: Int,
    val description: String,
    val history: String,
    val website: String,
    val backgroundColor: Color,
    val cardColor: Color,
    val buttonColor: Color,
    val gradeColor: Color,
    val offsetX: Float = 0f,
    val offsetY: Float = 0f,
    val imageSize: Dp = 120.dp,
    val logoSize: Dp = 120.dp,
    val textSize: TextUnit  = 40.sp,
    val backColor: Color,
    val politicians: List<Actor> = emptyList(),
    val policies: String = ""
)

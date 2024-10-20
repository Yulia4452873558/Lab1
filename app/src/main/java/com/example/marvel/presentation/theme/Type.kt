package com.example.marvel.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.marvel.R

val mainFont: FontFamily =
    FontFamily(Font(resId = R.font.inter_bold, weight = FontWeight.Bold))

val Typography = Typography(
    headlineLarge = TextStyle(
        fontSize = 32.sp,
        fontFamily = mainFont,
        fontWeight = FontWeight.ExtraBold,
        letterSpacing = 0.05.sp
    ),
    headlineMedium = TextStyle(
        fontSize = 28.sp,
        fontFamily = mainFont,
        fontWeight = FontWeight.ExtraBold,
        letterSpacing = 0.05.sp
    ),
    titleLarge = TextStyle(
        fontSize = 34.sp,
        fontFamily = mainFont,
        fontWeight = FontWeight.ExtraBold,
        letterSpacing = 0.05.sp
    ),
    titleMedium = TextStyle(
        fontSize = 22.sp,
        fontFamily = mainFont,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.05.sp
    )
)
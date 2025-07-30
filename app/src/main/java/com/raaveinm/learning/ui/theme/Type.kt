package com.raaveinm.learning.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.raaveinm.learning.R

val Monsterrat = FontFamily(
    Font(R.font.montserrat_regular),
    Font(R.font.montserrat_bold, FontWeight.Bold),
    Font(R.font.montserrat_thin, FontWeight.Thin)
)

val LeTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = Monsterrat,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Monsterrat,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    ),
    displaySmall = TextStyle(
        fontFamily = Monsterrat,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    )
)
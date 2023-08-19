package com.example.littlelemon.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R

// Set of Material typography styles to start with
private val markaziFont = FontFamily(
    Font(R.font.markazitext_regular),
)

private val karlaFont = FontFamily(
    Font(R.font.karla_regular),
)

val Typography = Typography(
    defaultFontFamily = karlaFont,
    body1 = TextStyle(
        fontFamily = markaziFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

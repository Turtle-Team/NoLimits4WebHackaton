package com.lyadsky.nolimits4webapp.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalColors = compositionLocalOf<Colors>{ error("colors wasnt provided") }

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val dayColors = Colors(
        background = Color.White,
        color1 = Color(0xFF9094FB),
        color2 = Color(0xFF66D5FD),
        color3 = Color(0xFF98D14B),
        color4 = Color(0xFFFEB242),
        color5 =Color(0xFFF791A4),
        color6 = Color(0xFF474992)
    )

    //FIXME если будет палитра для тёмной темы заменить цвета
    val nightColors = Colors(
        background = Color.White,
        color1 = Color(0xFF9094FB),
        color2 = Color(0xFF66D5FD),
        color3 = Color(0xFF98D14B),
        color4 = Color(0xFFFEB242),
        color5 =Color(0xFFF791A4),
        color6 = Color(0xFF474992)
    )

    CompositionLocalProvider(LocalColors provides if (darkTheme) dayColors else nightColors){
        content()
    }
}

data class Colors(
    val background: Color,
    val color1: Color,
    val color2: Color,
    val color3: Color,
    val color4: Color,
    val color5: Color,
    val color6: Color
)
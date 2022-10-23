package kr.duckcade.kockkock.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val BasicColorPalette = lightColors(
    primary = Color.White,
    background = Yellow,
    onPrimary = Color.Black,
    surface = Color.Black,
    onSurface = Color.Black
)

@Composable
fun KockKockTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = BasicColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
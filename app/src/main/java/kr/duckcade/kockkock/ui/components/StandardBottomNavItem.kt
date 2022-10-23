package kr.duckcade.kockkock.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import kr.duckcade.kockkock.ui.theme.SpaceSmall

@Composable
@Throws(IllegalArgumentException::class)
fun RowScope.StandardBottomNavItem(
    modifier: Modifier = Modifier,
    title: String? = null,
    icon: ImageVector? = null,
    contentDescription: String? = null,
    selected: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    if (title != null && title.length > 10) {
        throw IllegalArgumentException("Title length cannot exceed 10.")
    }

    BottomNavigationItem(
        selected = selected,
        onClick = onClick,
        modifier = modifier.background(Color.White),
        enabled = enabled,
        icon = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                if(icon != null) {
                    Icon(
                        imageVector = icon,
                        contentDescription = contentDescription,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
                if (title != null) {
                    Text(
                        text = title,
                        modifier = Modifier
                            .padding(top = 30.dp)
                            .align(Alignment.BottomCenter)

                    )
                }
            }
        }
    )
}
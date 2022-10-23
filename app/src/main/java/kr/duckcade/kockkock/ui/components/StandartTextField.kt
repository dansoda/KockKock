package kr.duckcade.kockkock.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun StandardTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = "",
    maxLength: Int = 40,
    maxLines: Int = 1,
    leadingIcon: ImageVector? = null,
    onValueChange: (String) -> Unit
) {
    Column(modifier = modifier
        .fillMaxWidth()
    ) {
        TextField(value = text, onValueChange = {
            if (it.length <= maxLength) {
                onValueChange(it)
            }
        },
            placeholder = {
                Text(text = hint)
            }
        )
    }
}
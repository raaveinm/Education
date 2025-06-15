package com.raaveinm.learning.ui.layouts

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EditNumberField (
    modifier: Modifier = Modifier,
    text: String,
    icon: ImageVector? = Icons.Default.Refresh,
    label: String = "",
    onValueChange: (String) -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            modifier = modifier,
            value = text,
            onValueChange = { onValueChange(it) },
            label = { Text(text = label) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            leadingIcon = { icon?.let { Icon(imageVector = it, contentDescription = null) } }
        )
    }
}

@Preview
@Composable
fun preview () {
    EditNumberField(
        onValueChange = {},
        text = "Jojo"
    )
}

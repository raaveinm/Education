package com.raaveinm.learning.ui.layouts

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raaveinm.learning.R

@Composable
fun SwitchLayout (
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    isChecked: Boolean,
    onCheckupChanged: (Boolean) -> Unit
){
    Row (
        modifier = modifier
            .fillMaxWidth()
            .size(48.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.bodyLarge,
        )

        Switch(
            checked = isChecked,
            onCheckedChange = { onCheckupChanged(it) }
        )
    }
}

@Preview
@Composable
fun SwitchLayoutPreview () {
    SwitchLayout(text = R.string.round_up_tip, isChecked = true, onCheckupChanged = {})
}
package com.raaveinm.learning.ui.layouts

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.raaveinm.learning.R

@Composable
fun DogHobby (
    @StringRes dogHobby: Int,
    modifier: Modifier = Modifier
){
    Column (
        modifier = modifier
    ){
        Text(
            text = stringResource(R.string.about),
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = stringResource(dogHobby),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
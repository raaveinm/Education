package com.raaveinm.learning.ui.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raaveinm.learning.R
import com.raaveinm.learning.data.Coffees

@Composable
fun RecipeCard(
    coffee: Coffees,
    modifier: Modifier,
    toExpandedScreen: () -> Unit
) {
    Card (
        modifier = modifier.fillMaxWidth(),
        onClick = toExpandedScreen
    ){
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Image(
                modifier = Modifier.size(128.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(coffee.imageResourceId),
                contentDescription = null,
            )
            Column (
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            ){
                Text(
                    text = stringResource(coffee.name),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium))
                )
                Text(
                    text = stringResource(coffee.description),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@Preview
@Composable
fun RecipeCardPreview(){
    RecipeCard(
        coffee = Coffees(
            imageResourceId = R.drawable.latte,
            name = R.string.latte,
            description = R.string.latte_description,
            recipe = R.string.latte_recipe
        ),
        modifier = Modifier,
        toExpandedScreen = {}
    )
}
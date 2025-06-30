package com.raaveinm.learning.ui.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.raaveinm.learning.R
import com.raaveinm.learning.data.Coffees
import com.raaveinm.learning.ui.navigation.DetailedImage
import com.raaveinm.learning.ui.theme.LearningTheme

@Composable
fun RecipeExtended(
    coffee: Coffees,
    navController: NavHostController
) {
    Column (
        Modifier
            .verticalScroll(rememberScrollState())
    ){
        Image(
            painter = painterResource(id = coffee.imageResourceId),
            contentDescription = null,
            modifier = Modifier
                .clickable( onClick = {
                    navController.navigate(DetailedImage(coffeeImage = coffee.imageResourceId))
                } )
                .clip(MaterialTheme.shapes.medium)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = stringResource(id = coffee.name),
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
        )

        Text(
            text = stringResource(id = coffee.description),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
        )

        Text(
            text = stringResource(id = coffee.recipe),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
    }
}

@Preview
@Composable
fun RecipeExtendedCardPreview() {
    LearningTheme {
        RecipeExtended(
            coffee = Coffees(R.drawable.latte, R.string.latte, R.string.latte_description, R.string.latte_recipe),
            navController = NavHostController(LocalContext.current)
        )
    }
}
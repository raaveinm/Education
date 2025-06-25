package com.raaveinm.learning.ui.layouts

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import com.raaveinm.learning.R
import com.raaveinm.learning.data.coffees
import com.raaveinm.learning.ui.navigation.RecipeScreen

@Composable
fun AllRecipes (
    navController: NavHostController,
    modifier: Modifier
){
    LazyColumn (
        modifier
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.medium)
    ) {
        items(items = coffees) { coffee->
            RecipeCard(
                coffee = coffee,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)),
                toExpandedScreen = { navController.navigate(RecipeScreen(coffeeNameId = coffee.name)) }
            )
        }
    }
}

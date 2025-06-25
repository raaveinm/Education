package com.raaveinm.learning.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.raaveinm.learning.data.coffees
import com.raaveinm.learning.ui.layouts.AllRecipes
import com.raaveinm.learning.ui.layouts.FullScreenImage
import com.raaveinm.learning.ui.layouts.RecipeExtended
import com.raaveinm.learning.ui.navigation.DetailedImage
import com.raaveinm.learning.ui.navigation.MainScreen
import com.raaveinm.learning.ui.navigation.RecipeScreen

@Composable
fun MainScreen (
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        modifier = Modifier
    ) { innerPadding ->
        NavHost(navController, startDestination = MainScreen) {
            composable<MainScreen> {
                AllRecipes(navController, modifier = Modifier.padding(innerPadding))
            }

            composable<RecipeScreen> { backStackEntry ->
                val recipeScreen: RecipeScreen = backStackEntry.toRoute()
                val selectedCoffee = coffees.find { it.name == recipeScreen.coffeeNameId }

                if (selectedCoffee != null) {
                    RecipeExtended(
                        coffee = selectedCoffee,
                        navController = navController
                    )
                }
            }

            composable<DetailedImage> { backStackEntry ->
                val detailedImage: DetailedImage = backStackEntry.toRoute()
                val selectedCoffee = coffees.find { it.imageResourceId == detailedImage.coffeeImage }
                if (selectedCoffee != null) { FullScreenImage(image = selectedCoffee.imageResourceId) }
            }
        }
    }
}
package com.raaveinm.learning.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object MainScreen

@Serializable
data class RecipeScreen(val coffeeNameId: Int)

@Serializable
data class DetailedImage(val coffeeImage: Int)
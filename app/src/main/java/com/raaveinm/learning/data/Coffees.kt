package com.raaveinm.learning.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.raaveinm.learning.R
import kotlinx.serialization.Serializable

@Serializable
data class Coffees(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    @StringRes val description: Int,
    @StringRes val recipe: Int
)

val coffees = listOf(
    Coffees(R.drawable.latte, R.string.latte, R.string.latte_description, R.string.latte_recipe),
    Coffees(R.drawable.vieticedcoffee, R.string.vietnamese_iced_latte, R.string.vietnamese_iced_latte_description, R.string.vietnamese_iced_latte_recipe),
    Coffees(R.drawable.espressomudslide, R.string.espresso_mudslide, R.string.espresso_mudslide_description, R.string.espresso_mudslide_recipe),
    Coffees(R.drawable.cortado, R.string.cortado, R.string.cortado_description, R.string.cortado_recipe),
    Coffees(R.drawable.flatwhite, R.string.flat_white, R.string.flat_white_description, R.string.flat_white_description),
)

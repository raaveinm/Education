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
    Coffees(R.drawable.chocolatehazelnutmocha, R.string.hazelnut_mocha_latte, R.string.hazelnut_mocha_latte_description, R.string.hazelnut_mocha_latte_recipe),
    Coffees(R.drawable.goldenlatte, R.string.golden_milk_latte, R.string.golden_milk_latte_description, R.string.golden_milk_latte_recipe),
    Coffees(R.drawable.cafeaulait, R.string.cafe_au_lait, R.string.cafe_au_lait_description, R.string.cafe_au_lait_recipe),
    Coffees(R.drawable.americano, R.string.americano, R.string.americano_description, R.string.americano_recipe),
    Coffees(R.drawable.cappuccino, R.string.cappuccino, R.string.cappuccino_description, R.string.cappuccino_recipe),
)

/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.raaveinm.learning.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.raaveinm.learning.R

/**
 * A data class to represent the information presented in the dog card
 */
data class Dog(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val age: Int,
    @StringRes val hobbies: Int
)

val dogs = listOf(
    Dog(R.drawable.mornin, R.string.dog_name_1, 22, R.string.dog_description_1),
    Dog(R.drawable.reilukah, R.string.dog_name_2, 26, R.string.dog_description_2),
    Dog(R.drawable.hibiki, R.string.dog_name_3, 22, R.string.dog_description_3),
    Dog(R.drawable.luma_lynx, R.string.dog_name_4, 18, R.string.dog_description_4),
    Dog(R.drawable.quetz_row, R.string.dog_name_5, 18, R.string.dog_description_5),
    Dog(R.drawable.serpentx, R.string.dog_name_6, 24, R.string.dog_description_6),
    Dog(R.drawable.archer, R.string.dog_name_7, 22, R.string.dog_description_7),
    Dog(R.drawable.bahl, R.string.dog_name_8, 17, R.string.dog_description_8),
    Dog(R.drawable.novaloux, R.string.dog_name_9, 24, R.string.dog_description_9)
)

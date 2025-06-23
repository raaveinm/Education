package com.raaveinm.learning.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.raaveinm.learning.R
import com.raaveinm.learning.data.dogs
import com.raaveinm.learning.ui.layouts.DogItem
import com.raaveinm.learning.ui.layouts.WoofTopAppBar

@Composable
fun MainScreen () {
    Scaffold(
        topBar = { WoofTopAppBar() },
        modifier = Modifier
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(dogs) { dog ->
                DogItem(
                    dog = dog,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}
package com.raaveinm.learning.ui.layouts

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.raaveinm.learning.R
import com.raaveinm.learning.ui.theme.LearningTheme

@Composable
fun DogIcon (
    @DrawableRes dogIcon: Int,
    modifier: Modifier = Modifier
){
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(dogIcon),
        contentDescription = null
    )
}

@Preview
@Composable
fun DogIconPreview() {
    LearningTheme {
        Column {
            DogIcon(dogIcon = R.drawable.luma_lynx)
            DogIcon(dogIcon = R.drawable.mornin)
            DogIcon(dogIcon = R.drawable.bahl)
            DogIcon(dogIcon = R.drawable.quetz_row)
            DogIcon(dogIcon = R.drawable.hibiki)
            DogIcon(dogIcon = R.drawable.reilukah)
        }
    }
}
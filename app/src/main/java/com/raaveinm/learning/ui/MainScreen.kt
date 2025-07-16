package com.raaveinm.learning.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raaveinm.learning.ui.theme.Shapes

@Composable
fun MainScreen (
    modifier: Modifier = Modifier
) {

//        DiceRoller(
//            modifier = Modifier
//                .padding(it)
//                .fillMaxSize()
//                .wrapContentSize(Alignment.Center)
//        )
        Surface () {
            ListSample(modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp))
        }

}

@Composable
fun ListSample(modifier: Modifier = Modifier) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive( minSize = 186.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(items = cardList) { item ->
            Image(
                painter = painterResource(id = item.imageResource),
                contentDescription = item.imageResource.toString(),
                modifier = Modifier
                    .width(384.dp)
                    .padding(4.dp),
                )
        }
    }
}


@Preview(showBackground = false, device = "spec:parent=pixel_5,orientation=portrait",)
@Composable
fun MainScreenPreview() {
    ListSample(Modifier.fillMaxSize())
}

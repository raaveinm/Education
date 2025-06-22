package com.raaveinm.learning.ui.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Abc
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raaveinm.learning.R
import com.raaveinm.learning.data.Topic

@Composable
fun CardItem (
    topic: Topic,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
    ){
        Row {
            Image(
                painter = painterResource(id = topic.imageResourceId),
                contentDescription = stringResource(id = topic.stringResourceId),
                modifier = Modifier
                    .height(68.dp),
                contentScale = ContentScale.Crop
            )

            Column (
                modifier = Modifier.padding(horizontal = 14.dp).padding(top = 16.dp),
//                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Text(text = stringResource(topic.stringResourceId), modifier = Modifier, style = MaterialTheme.typography.bodyMedium)

                Row (
                    modifier = Modifier.padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.Abc, contentDescription = null)
                    Text(text = "${topic.courses}", modifier = Modifier.padding(start = 8.dp), style = MaterialTheme.typography.labelMedium)
                }
            }
        }
    }
}

@Preview
@Composable
fun CardItemPreview () {
    CardItem(topic = Topic(stringResourceId = R.string.tech, courses = 434, imageResourceId = R.drawable.tech))
}
package com.raaveinm.learning.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.Modifier

@Composable
fun MainScreen (
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Column (
        modifier,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {
        Button(
            onClick = {showNotification(context)}
        ) {
            Text(text = "Show Notification")
        }
    }
}

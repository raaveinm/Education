package com.raaveinm.learning.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.raaveinm.learning.data.WorkManagerRepository

@Composable
fun MainScreen (
    modifier: Modifier = Modifier
) {
    Column (
        modifier,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {
        Button(
            onClick = { WorkManagerRepository().startOneTimeSampleWork() },
            content = { Text("Start One Time Work") }
        )

        Button(
            onClick = { WorkManagerRepository().chainOneTimeSampleWork() },
            content = { Text("Start Chain Work") }
        )

        Button(
            onClick = { WorkManagerRepository().startScheduledWork() },
            content = { Text("Start Scheduled Work ") }
        )

        Button(
            onClick = { WorkManagerRepository().beginUbiqueChain() },
            content = { Text("Begin Ubique Chain") }
        )

        Button(
            onClick = { WorkManagerRepository().cancelWork() },
            content = { Text("Cancel Work") }
        )
    }
}

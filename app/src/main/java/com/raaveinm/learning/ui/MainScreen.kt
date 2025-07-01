package com.raaveinm.learning.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.raaveinm.learning.ui.layouts.DiceRoller

@Composable
fun MainScreen (
    modifier: Modifier = Modifier.fillMaxSize()
) {
    Scaffold(
        modifier = modifier
    ){ it->
        DiceRoller(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }
}


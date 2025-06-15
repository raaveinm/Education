package com.raaveinm.learning.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.raaveinm.learning.ui.layouts.TipCalculatorScreen

@Composable
fun MainScreen () {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        TipCalculatorScreen(modifier = Modifier.padding(innerPadding))
    }
}
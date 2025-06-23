package com.raaveinm.learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.raaveinm.learning.ui.MainScreen
import com.raaveinm.learning.ui.theme.LearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { LearningTheme { Surface(modifier = Modifier.fillMaxSize()) { MainScreen() } } }
    }
}


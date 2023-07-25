package com.example.simplegameroulette

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.simplegameroulette.roulette_screen.RouletteScreen
import com.example.simplegameroulette.ui.theme.SimpleGameRouletteTheme
import com.example.simplegameroulette.ui.theme.green

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleGameRouletteTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = green
                ) {
                    RouletteScreen()
                }
            }
        }
    }
}

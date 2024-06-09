package ua.sten.tachograph.ui.screens

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import ua.sten.tachograph.ui.theme.TachographTheme
import ua.sten.tachograph.ui.viewmodels.TimerViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            TachographTheme {
                val timerViewModel: TimerViewModel by viewModels()
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    CountryListScreen()
                    TimerScreenContent(timerViewModel, this)
                    //MainScreen(this)
                    //val intent = Intent(this, TimerService::class.java)
                    //startService(intent)
                }
            }
        }
    }
}
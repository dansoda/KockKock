package kr.duckcade.kockkock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import kr.duckcade.kockkock.ui.Navigation
import kr.duckcade.kockkock.ui.theme.KockKockTheme
import kr.duckcade.kockkock.ui.theme.Yellow
import kr.duckcade.kockkock.ui.utils.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KockKockTheme {
                Surface(
                    color = Yellow,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    Navigation(navController)
                }
            }
        }
    }
}

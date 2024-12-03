package org.comon.composevideoplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import org.comon.composevideoplayer.common.VPPreferences
import org.comon.composevideoplayer.ui.screen.VPNavigation
import org.comon.composevideoplayer.ui.theme.ComposeVideoPlayerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        VPPreferences.init(this)
        setContent {
            VideoPlayerApp()
        }
    }

    @Composable
    fun VideoPlayerApp(){
        val darkThemeState = remember { mutableStateOf(VPPreferences.getDarkTheme()) }
        ComposeVideoPlayerTheme(
            darkTheme = darkThemeState.value
        ) {
            val navController = rememberNavController()
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                VPNavigation(innerPadding, navController, darkThemeState)
            }
        }
    }

}

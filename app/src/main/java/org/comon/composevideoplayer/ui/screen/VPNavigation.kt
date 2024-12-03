package org.comon.composevideoplayer.ui.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun VPNavigation(
    innerPadding: PaddingValues,
    navController: NavHostController,
    darkThemeState: MutableState<Boolean>,
){
    NavHost(
        modifier = Modifier.padding(innerPadding),
        startDestination = VPRoute.VideoPlayRoute.str,
        navController = navController,
    ){
        // 동영상 리스트, 재생 화면
        videoGraph(navController)

        // 셋팅 화면
        composable(route = VPRoute.SettingRoute.str) {
            SettingScreen(darkThemeState)
        }
    }
}
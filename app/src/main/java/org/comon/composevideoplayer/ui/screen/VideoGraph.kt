package org.comon.composevideoplayer.ui.screen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

fun NavGraphBuilder.videoGraph(navController: NavHostController) {
    composable(route = VPRoute.VideoListRoute.str) {
        VideoListScreen()
    }
    composable(route = VPRoute.VideoPlayRoute.str) {
        VideoPlayScreen()
    }
}

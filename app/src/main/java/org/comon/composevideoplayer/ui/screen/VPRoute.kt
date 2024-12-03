package org.comon.composevideoplayer.ui.screen

sealed class VPRoute(val str: String){
    data object VideoListRoute: VPRoute("video_list_route")
    data object VideoPlayRoute: VPRoute("video_play_route")
    data object SettingRoute: VPRoute("setting_route")
}
package org.comon.composevideoplayer.ui.screen

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import org.comon.composevideoplayer.ui.viewmodel.PlayerViewModel

@Composable
fun VideoPlayScreen(){

    val activity = LocalContext.current as Activity
    val viewModel: PlayerViewModel = viewModel()

    Column {
        ExoPlayerView(
            context = LocalContext.current,
            videoUri = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            modifier = Modifier.fillMaxWidth().background(color = Color.Black),
            viewModel
        )
        Button(
            onClick = {
                if(viewModel.isFullScreen.value){
                    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
                    viewModel.setIsFullScreen(false)
                }else{
                    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                    viewModel.setIsFullScreen(true)
                }

            }
        ) {
            Text(text = "전체화면")
        }
    }

}

@androidx.annotation.OptIn(UnstableApi::class)
@Composable
fun ExoPlayerView(
    context: Context,
    videoUri: String,
    modifier: Modifier = Modifier,
    viewModel: PlayerViewModel
) {
    // Initialize ExoPlayer
    val exoPlayer = remember { ExoPlayer.Builder(context).build() }

    // MediaSource를 생성하기 위한 DataSource.Factory 인스턴스 준비
    val dataSourceFactory = DefaultDataSource.Factory(context)

    // Create a MediaSource
    val mediaSource = remember(videoUri) {
        ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(
                MediaItem.fromUri(Uri.parse(videoUri))
            )
    }

    // Uri 변경 시마다 Exoplayer 셋팅
    LaunchedEffect(mediaSource) {
        exoPlayer.setMediaSource(mediaSource)
        exoPlayer.prepare()
        exoPlayer.seekTo(viewModel.playbackPosition.value)
        exoPlayer.playWhenReady = true // 자동 재생
    }

    // 생명주기 종료 시 Exoplayer 메모리 해제
    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
            viewModel.setPlaybackPosition(exoPlayer.currentPosition)
        }
    }

    // Exoplayer with AndroidView
    AndroidView(
        factory = { ctx ->
            PlayerView(ctx).apply {
                player = exoPlayer
                resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT
            }
        },
        modifier = modifier
    )
}
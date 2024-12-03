package org.comon.composevideoplayer.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PlayerViewModel:ViewModel() {

    private var _isFullScreen = MutableStateFlow(false)
    val isFullScreen get() = _isFullScreen as StateFlow<Boolean>
    fun setIsFullScreen(value: Boolean) {
        _isFullScreen.value = value
    }

    private var _playWhenReady = MutableStateFlow(true)
    val playWhenReady get() =  _playWhenReady as StateFlow<Boolean>
    fun setPlayWhenReady(value: Boolean) {
        _playWhenReady.value = value
    }

    private var _currentMediaItemIndex = MutableStateFlow(0)
    val currentMediaItemIndex get() = _currentMediaItemIndex as StateFlow<Int>
    fun setCurrentMediaItemIndex(value: Int) {
        _currentMediaItemIndex.value = value
    }

    private var _playbackPosition = MutableStateFlow(0L)
    val playbackPosition = _playbackPosition as StateFlow<Long>
    fun setPlaybackPosition(value: Long) {
        _playbackPosition.value = value
    }
}
package org.comon.composevideoplayer.common

import android.app.Application

class ComposeVideoPlayerApplication: Application() {

    companion object {
        private lateinit var composeVideoPlayerApplication: ComposeVideoPlayerApplication
        val context: ComposeVideoPlayerApplication
            get() = composeVideoPlayerApplication
    }

    override fun onCreate() {
        super.onCreate()
        composeVideoPlayerApplication = this
    }
}
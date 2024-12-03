package org.comon.composevideoplayer.common

import android.content.Context
import android.content.SharedPreferences

object VPPreferences {

    private const val PREFERENCES_NAME = "mfPreferences"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var vpPreferences: SharedPreferences

    fun init(context: Context) {
        vpPreferences = context.getSharedPreferences(PREFERENCES_NAME, MODE)
    }

    fun setDarkTheme(isDarkTheme: Boolean) {
        vpPreferences.edit()
            .putBoolean("darkTheme", isDarkTheme)
            .apply()
    }

    fun getDarkTheme() = vpPreferences.getBoolean("darkTheme", false)

}
package com.space.chatApp.presentation.utils

import android.content.Context
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

object ThemeUtils {
    const val LIGHT_MODE = "light"
    const val DARK_MODE = "dark"

    fun getThemeMode(context: Context): String {
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)
        return sharedPrefs.getString("theme_mode", LIGHT_MODE) ?: LIGHT_MODE
    }

    fun setThemeMode(context: Context, themeMode: String) {
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = sharedPrefs.edit()
        editor.putString("theme_mode", themeMode)
        editor.apply()
    }

    fun applyThemeMode(activity: AppCompatActivity) {
        val nightMode = when (getThemeMode(activity)) {
            DARK_MODE -> AppCompatDelegate.MODE_NIGHT_YES
            else -> AppCompatDelegate.MODE_NIGHT_NO
        }
        AppCompatDelegate.setDefaultNightMode(nightMode)
    }
}

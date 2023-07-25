package com.kocci.disastertracker.util.helper

import androidx.appcompat.app.AppCompatDelegate

object ThemeHelper {
    fun enableDarkTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }

    fun disableDarkTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}
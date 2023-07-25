package com.kocci.disastertracker.data.source.local.preferences

import android.content.Context
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferenceManager @Inject constructor(@ApplicationContext private val context: Context) {

    private val fileName = "USER_SETTING_PREFERENCE"
    private val preference = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)

    private object Keys {
        val isDarkTheme = "IS_DARK_THEME"
    }

    fun getDarkThemePreference(): Boolean {
        return preference.getBoolean(Keys.isDarkTheme, false)
    }

    fun setDarkThemePreference(state: Boolean) {
        preference.edit {
            putBoolean(Keys.isDarkTheme, state)
        }
    }
}
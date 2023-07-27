package com.kocci.disastertracker.data.source.local.preferences

import android.content.Context
import androidx.core.content.edit
import com.kocci.disastertracker.data.enums.AvailableReportPeriod
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferenceManager @Inject constructor(@ApplicationContext private val context: Context) {

    private val fileName = "USER_SETTING_PREFERENCE"
    private val preference = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)

    private object Keys {
        const val isDarkTheme = "IS_DARK_THEME"
        const val timePeriod = "REPORT_PERIOD"
    }

    fun getDarkThemePreference(): Boolean {
        return preference.getBoolean(Keys.isDarkTheme, false)
    }


    fun getReportPeriod(): AvailableReportPeriod {
        val default = AvailableReportPeriod.ONE_WEEK
        val pref = preference.getString(Keys.timePeriod, default.name)!!
        return AvailableReportPeriod.valueOf(pref)
    }

    fun setDarkThemePreference(state: Boolean) {
        preference.edit {
            putBoolean(Keys.isDarkTheme, state)
            apply()
        }
    }

    fun setReportPeriod(time: AvailableReportPeriod) {
        preference.edit {
            val savePeriod = time.name
            putString(Keys.timePeriod, savePeriod)
            apply()
        }
    }
}
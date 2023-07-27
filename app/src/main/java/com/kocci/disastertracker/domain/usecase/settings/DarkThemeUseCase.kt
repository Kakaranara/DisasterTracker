package com.kocci.disastertracker.domain.usecase.settings

interface DarkThemeUseCase {
    fun shouldEnableDarkTheme()
    fun enableDarkTheme()
    fun disableDarkTheme()
    fun isDarkThemeEnabled() : Boolean
}
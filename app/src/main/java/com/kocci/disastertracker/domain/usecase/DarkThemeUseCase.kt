package com.kocci.disastertracker.domain.usecase

interface DarkThemeUseCase {
    fun shouldEnableDarkTheme()
    fun enableDarkTheme()
    fun disableDarkTheme()
    fun isDarkThemeEnabled() : Boolean
}
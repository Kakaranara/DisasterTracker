package com.kocci.disastertracker

import android.app.Application
import com.kocci.disastertracker.domain.usecase.DarkThemeUseCase
import com.kocci.disastertracker.util.helper.NotificationHelper
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class RootApplication : Application() {
    /**
     * This application class called once the application built.
     * Register activity lifecycle, or something that should be setup at first app opens.
     * Override the onCreate if you wish
     */
    @Inject
    lateinit var darkThemeUseCase: DarkThemeUseCase

    override fun onCreate() {
        super.onCreate()
        darkThemeUseCase.shouldEnableDarkTheme()
        NotificationHelper.createNotificationChannel(this)
    }
}
package com.kocci.disastertracker

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RootApplication  : Application(){
    /**
     * This application class called once the application built.
     * Register activity lifecycle, or something that should be setup at first app opens.
     * Override the onCreate if you wish
     */
}
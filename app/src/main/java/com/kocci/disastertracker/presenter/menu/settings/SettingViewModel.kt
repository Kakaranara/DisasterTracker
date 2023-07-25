package com.kocci.disastertracker.presenter.menu.settings

import androidx.lifecycle.ViewModel
import com.kocci.disastertracker.domain.usecase.DarkThemeUseCase
import com.kocci.disastertracker.util.helper.MyLogger
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(private val useCase: DarkThemeUseCase) : ViewModel() {

    init {
        MyLogger.e("VM Init")
    }

    fun enableDarkTheme() = useCase.enableDarkTheme()
    fun disableDarkTheme() = useCase.disableDarkTheme()
    val isDarkModeEnabled = useCase.isDarkThemeEnabled()
}
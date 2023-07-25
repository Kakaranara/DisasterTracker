package com.kocci.disastertracker.presenter.menu.settings

import androidx.lifecycle.ViewModel
import com.kocci.disastertracker.domain.usecase.DarkThemeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(private val useCase: DarkThemeUseCase) : ViewModel() {
    fun enableDarkTheme() = useCase.enableDarkTheme()
    fun disableDarkTheme() = useCase.disableDarkTheme()
    val isDarkModeEnabled = useCase.isDarkThemeEnabled()
}
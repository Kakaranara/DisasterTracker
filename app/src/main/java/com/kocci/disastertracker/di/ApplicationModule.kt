package com.kocci.disastertracker.di

import com.kocci.disastertracker.domain.usecase.settings.DarkThemeUseCase
import com.kocci.disastertracker.domain.usecase.settings.DarkThemeUseCaseImpl
import com.kocci.disastertracker.domain.usecase.settings.ReportTimePeriodUseCase
import com.kocci.disastertracker.domain.usecase.settings.ReportTimePeriodUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ApplicationModule {

    //this use case are used in application class, so we need it to be singleton.
    @Binds
    abstract fun provideDarkThemeUseCase(impl: DarkThemeUseCaseImpl): DarkThemeUseCase

    @Binds
    abstract fun provideReportTimePeriodUseCase(impl: ReportTimePeriodUseCaseImpl): ReportTimePeriodUseCase
}
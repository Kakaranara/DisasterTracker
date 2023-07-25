package com.kocci.disastertracker.di

import com.kocci.disastertracker.domain.usecase.ReportDisasterUseCase
import com.kocci.disastertracker.domain.usecase.ReportDisasterUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun provideReportUseCase(impl: ReportDisasterUseCaseImpl): ReportDisasterUseCase

//    @Binds
//    abstract fun provideDarkThemeUseCase(impl: DarkThemeUseCaseImpl): DarkThemeUseCase
}
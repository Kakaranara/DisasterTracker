package com.kocci.disastertracker.di

import com.kocci.disastertracker.domain.usecase.ReportDisasterUseCaseImpl
import com.kocci.disastertracker.domain.usecase.ReportDisasterUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun provideUseCase(interactor: ReportDisasterUseCaseImpl): ReportDisasterUseCase
}
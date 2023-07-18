package com.kocci.disastertracker.di

import com.kocci.disastertracker.domain.interactor.RealtimeDisasterInteractor
import com.kocci.disastertracker.domain.usecase.RealtimeDisasterUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun provideUseCase(interactor: RealtimeDisasterInteractor) : RealtimeDisasterUseCase
}
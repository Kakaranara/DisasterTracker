package com.kocci.disastertracker.di

import com.kocci.disastertracker.domain.usecase.DarkThemeUseCase
import com.kocci.disastertracker.domain.usecase.DarkThemeUseCaseImpl
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
}
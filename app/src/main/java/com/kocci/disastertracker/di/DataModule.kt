package com.kocci.disastertracker.di

import com.kocci.disastertracker.data.repository.ReportRepositoryImpl
import com.kocci.disastertracker.domain.repository.ReportRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindReportRepository(reportRepositoryImpl: ReportRepositoryImpl): ReportRepository
}
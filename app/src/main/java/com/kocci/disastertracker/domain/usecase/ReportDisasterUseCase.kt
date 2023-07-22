package com.kocci.disastertracker.domain.usecase

import com.kocci.disastertracker.domain.model.Reports
import com.kocci.disastertracker.domain.reactive.Async
import kotlinx.coroutines.flow.Flow


interface ReportDisasterUseCase {
    fun getReportData(): Flow<Async<List<Reports>>>
}
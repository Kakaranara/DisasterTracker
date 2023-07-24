package com.kocci.disastertracker.domain.repository

import com.kocci.disastertracker.domain.model.Reports
import com.kocci.disastertracker.domain.reactive.Async
import kotlinx.coroutines.flow.Flow

interface ReportRepository {
    fun getReportList(provinceName: String?): Flow<Async<List<Reports>>>
}
package com.kocci.disastertracker.domain.repository

import com.kocci.disastertracker.domain.model.reports.ReportTest
import com.kocci.disastertracker.domain.reactive.Async
import kotlinx.coroutines.flow.Flow

interface ReportRepository {
    fun getReportListTest(provinceName: String?, disasterType: String?): Flow<Async<List<ReportTest>>>

}

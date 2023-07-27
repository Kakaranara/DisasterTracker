package com.kocci.disastertracker.domain.usecase

import com.kocci.disastertracker.domain.model.Reports
import com.kocci.disastertracker.domain.reactive.Async
import kotlinx.coroutines.flow.Flow


interface ReportDisasterUseCase {
    fun getAllReportData(
        provinceName: String? = null,
        disasterType: String? = null,
    ): Flow<Async<List<Reports>>>

    fun showFloodDangerNotification(floodDepth: Int)

    fun getAvailableProvince(): List<String>
}
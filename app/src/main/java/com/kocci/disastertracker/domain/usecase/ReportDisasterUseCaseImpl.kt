package com.kocci.disastertracker.domain.usecase

import com.kocci.disastertracker.domain.model.Reports
import com.kocci.disastertracker.domain.reactive.Async
import com.kocci.disastertracker.domain.repository.ReportRepository
import com.kocci.disastertracker.util.helper.ProvinceHelper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReportDisasterUseCaseImpl @Inject constructor(
    private val repository: ReportRepository
) : ReportDisasterUseCase {
    override fun getReportData(provinceName: String?, disasterType: String?): Flow<Async<List<Reports>>> {
        return repository.getReportList(provinceName, disasterType)
    }

    override fun getAvailableProvince(): List<String> = ProvinceHelper.getAvailableProvince()

}
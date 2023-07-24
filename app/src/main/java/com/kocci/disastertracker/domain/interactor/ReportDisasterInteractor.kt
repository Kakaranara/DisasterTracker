package com.kocci.disastertracker.domain.interactor

import com.kocci.disastertracker.data.enums.AvailableProvince
import com.kocci.disastertracker.data.repository.AppRepository
import com.kocci.disastertracker.domain.model.Reports
import com.kocci.disastertracker.domain.reactive.Async
import com.kocci.disastertracker.domain.usecase.ReportDisasterUseCase
import com.kocci.disastertracker.util.helper.ProvinceHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.lang.Exception
import javax.inject.Inject

class ReportDisasterInteractor @Inject constructor(
    private val repository: AppRepository
) : ReportDisasterUseCase {
    override fun getReportData(provinceName: String?): Flow<Async<List<Reports>>> {
        return repository.getReportList(provinceName)
    }

    override fun getAvailableProvince(): List<String> = ProvinceHelper.getAvailableProvince()

}
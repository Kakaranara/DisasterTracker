package com.kocci.disastertracker.domain.interactor

import com.kocci.disastertracker.data.repository.AppRepository
import com.kocci.disastertracker.domain.model.Reports
import com.kocci.disastertracker.domain.reactive.Async
import com.kocci.disastertracker.domain.usecase.ReportDisasterUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReportDisasterInteractor @Inject constructor(
    private val repository: AppRepository
) : ReportDisasterUseCase {
    override fun getReportData(): Flow<Async<List<Reports>>> {
        return repository.getReportList()
    }


}
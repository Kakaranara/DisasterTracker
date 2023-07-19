package com.kocci.disastertracker.domain.interactor

import com.kocci.disastertracker.data.repository.AppRepository
import com.kocci.disastertracker.domain.usecase.ReportDisasterUseCase
import javax.inject.Inject

class ReportDisasterInteractor @Inject constructor(
    private val repository: AppRepository
) : ReportDisasterUseCase {

}
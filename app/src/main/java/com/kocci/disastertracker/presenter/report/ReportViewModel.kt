package com.kocci.disastertracker.presenter.report

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kocci.disastertracker.domain.usecase.ReportDisasterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ReportViewModel @Inject constructor(
    private val useCase: ReportDisasterUseCase
) : ViewModel(){
    val data = useCase.getReportData().asLiveData()
}
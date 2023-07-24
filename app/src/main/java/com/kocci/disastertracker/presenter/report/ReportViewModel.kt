package com.kocci.disastertracker.presenter.report

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.kocci.disastertracker.domain.model.Reports
import com.kocci.disastertracker.domain.reactive.Async
import com.kocci.disastertracker.domain.usecase.ReportDisasterUseCase
import com.kocci.disastertracker.util.helper.MyLogger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReportViewModel @Inject constructor(
    private val useCase: ReportDisasterUseCase
) : ViewModel() {

    //    val data = useCase.getReportData().asLiveData()
    val availableProvince = useCase.getAvailableProvince()

    /**
     * We use this because i need to listen reports in 2 different ways.
     * (onViewCreated and onMapsReady)
     */
    private var _reports: MutableLiveData<Async<List<Reports>>> = MutableLiveData()
    val reports: LiveData<Async<List<Reports>>> get() = _reports

    private var _test: MutableLiveData<Async<List<Reports>>> = MutableLiveData()


    init {
        callApi(
            provinceName = null
        )
    }

    fun callApi(provinceName: String?) {
//        _reports = useCase.getReportData(provinceName).asLiveData()
        viewModelScope.launch {
            useCase.getReportData(provinceName).collect {
                _reports.value = it
            }
        }
    }

}
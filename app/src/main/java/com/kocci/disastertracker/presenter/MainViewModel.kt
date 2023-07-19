package com.kocci.disastertracker.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kocci.disastertracker.data.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {
    val reportList = repository.getReportList().asLiveData()

}
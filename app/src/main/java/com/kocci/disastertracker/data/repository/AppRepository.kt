package com.kocci.disastertracker.data.repository

import com.kocci.disastertracker.data.source.remote.service.ApiService
import com.kocci.disastertracker.domain.model.Reports
import com.kocci.disastertracker.domain.reactive.Async
import com.kocci.disastertracker.util.mapper.convertReportApiResponseToDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val apiService: ApiService
) {
    fun getReportList(): Flow<Async<List<Reports>>> = flow {
        try {
            emit(Async.Loading)
            val apiResponse = apiService.getCrowdSourcingReport()
            if (apiResponse.isSuccessful) {
                val body = apiResponse.body() ?: throw Exception("Data is NULL!")
                val reportList = convertReportApiResponseToDomain(body)
                emit(Async.Success(reportList))
            } else {
                emit(Async.Error(apiResponse.message()))
            }
        } catch (e: Exception) {
            emit(Async.Error("Unexpected error : ${e.message}"))
        }
    }.flowOn(Dispatchers.IO)
}
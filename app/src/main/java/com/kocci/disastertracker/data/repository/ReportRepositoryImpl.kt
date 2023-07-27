package com.kocci.disastertracker.data.repository

import com.kocci.disastertracker.data.source.local.preferences.PreferenceManager
import com.kocci.disastertracker.data.source.remote.service.ApiService
import com.kocci.disastertracker.domain.model.Reports
import com.kocci.disastertracker.domain.reactive.Async
import com.kocci.disastertracker.domain.repository.ReportRepository
import com.kocci.disastertracker.util.exception.EmptyListException
import com.kocci.disastertracker.util.exception.NonsenseException
import com.kocci.disastertracker.util.exception.ProvinceNotFoundException
import com.kocci.disastertracker.util.helper.MyLogger
import com.kocci.disastertracker.util.helper.ProvinceHelper
import com.kocci.disastertracker.util.mapper.convertReportApiResponseToDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ReportRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val prefManager: PreferenceManager
) : ReportRepository {

    override fun getReportList(
        provinceName: String?,
        disasterType: String?
    ): Flow<Async<List<Reports>>> = flow {
        try {
            emit(Async.Loading)
            delay(500L) //just to show if loading exist.. remove later
            var code: String? = null
            val disaster = disasterType
            val timePeriod = prefManager.getReportPeriod().periodInSec

            if (provinceName != null) {
                code = ProvinceHelper.getProvinceCode(provinceName)
            }

            val apiResponse = apiService.getCrowdSourcingReport(
                provinceCode = code,
                disasterType = disaster,
                time = timePeriod
            )

            MyLogger.e(apiResponse.toString())
            if (apiResponse.isSuccessful) {
                val body =
                    apiResponse.body() ?: throw NonsenseException("This should not be happen.")
                val reportList =
                    convertReportApiResponseToDomain(body).filter { it.imgUrl != null }
                if (reportList.isEmpty()) {
                    throw EmptyListException("No reports available")
                }
                emit(Async.Success(reportList))
            } else {
                emit(Async.Error("Bad Request. Api not handled properly"))
            }

        } catch (e: ProvinceNotFoundException) { //enum not found
            emit(Async.Error(e.message.toString()))
        } catch (e: EmptyListException) {
            emit(Async.Error(e.message.toString()))
        } catch (e: NonsenseException) {
            emit(Async.Error("Unexpected Error. ${e.message}"))
            MyLogger.e("NonsenseException : ${e.message}")
        } catch (e: Exception) {
            emit(Async.Error("Error. ${e.message}"))
            MyLogger.e("Exception : ${e.message}")
        }
    }.flowOn(Dispatchers.IO)
}
package com.kocci.disastertracker.data.source.remote.service

import com.kocci.disastertracker.data.source.remote.response.ReportsApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //hit endpoint here
    @GET("reports")
    suspend fun getCrowdSourcingReport(@Query("timeperiod") time: Int = 604800): Response<ReportsApiResponse>
}
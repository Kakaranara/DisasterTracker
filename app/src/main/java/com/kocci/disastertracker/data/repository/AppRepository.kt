package com.kocci.disastertracker.data.repository

import com.kocci.disastertracker.data.source.ApiService
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val apiService : ApiService
){

}
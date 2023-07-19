package com.kocci.disastertracker.data.repository

import android.util.Log
import com.kocci.disastertracker.data.source.ApiService
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val apiService : ApiService
){
    fun testGetData() = runBlocking{
        try{
            val a = apiService.getCrowdSourcingReport()
            Log.e("REPO", "testGetData: $a", )
            Log.e("REPO", "code: ${a.code()}", )
            Log.e("REPO", "body: ${a.body()}", )
            Log.e("REPO", "body size: ${a.body()?.result?.objects?.output?.geometries?.size}", )

        }catch (e: Exception){
            Log.e("REPO", "exception : $e", )
        }
    }
}
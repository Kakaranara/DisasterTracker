package com.kocci.disastertracker.util.mapper

import com.kocci.disastertracker.data.source.remote.response.ReportsApiResponse
import com.kocci.disastertracker.domain.model.LatLng
import com.kocci.disastertracker.domain.model.Reports

fun convertReportApiResponseToDomain(reportsApiResponse: ReportsApiResponse): List<Reports> {
    val reportList = mutableListOf<Reports>()
    reportsApiResponse.result?.objects?.output?.geometries?.let { item ->
        item.map {
            val coordinates = LatLng(
                lat = (it?.coordinates?.get(1) ?: 0.0),
                lng = it?.coordinates?.get(0) ?: 0.0
            )
            val title = it?.properties?.title ?: "No title"
            val body = it?.properties?.text ?: "No Description"
            val imgUrl = it?.properties?.imageUrl

            val reports = Reports(coordinates, title, body, imgUrl)
            reportList.add(reports)
        }
    }
    return reportList
}
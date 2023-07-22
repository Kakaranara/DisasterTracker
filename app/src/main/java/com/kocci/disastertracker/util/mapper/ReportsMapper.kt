package com.kocci.disastertracker.util.mapper

import com.kocci.disastertracker.data.source.remote.response.ReportsApiResponse
import com.kocci.disastertracker.domain.model.Coordinates
import com.kocci.disastertracker.domain.model.Reports
import com.kocci.disastertracker.util.helper.DateHelper

fun convertReportApiResponseToDomain(reportsApiResponse: ReportsApiResponse): List<Reports> {
    val reportList = mutableListOf<Reports>()
    reportsApiResponse.result?.objects?.output?.geometries?.let { item ->
        item.map {
            val coordinates = Coordinates(
                lat = (it?.coordinates?.get(1) ?: 0.0),
                lng = it?.coordinates?.get(0) ?: 0.0
            )
            val title = it?.properties?.title ?: "No title"
            var body = it?.properties?.text ?: "No Description"
            val imgUrl = it?.properties?.imageUrl
            val date = it?.properties?.createdAt ?: ""
            val beautifyDate = DateHelper.beautifyDate(date)
            val disasterType = it?.properties?.disasterType ?: "Not Specified"

            if (body.isEmpty()) {
                body = "No Description"
            }
            val reports = Reports(coordinates, title, body, beautifyDate, imgUrl, disasterType)
            reportList.add(reports)
        }
    }
    return reportList
}
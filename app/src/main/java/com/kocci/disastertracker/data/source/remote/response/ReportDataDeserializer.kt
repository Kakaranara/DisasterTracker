package com.kocci.disastertracker.data.source.remote.response

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import com.kocci.disastertracker.util.helper.MyLogger
import java.lang.IllegalArgumentException
import java.lang.reflect.Type

/**
 * This api response was dynamic.
 * So we need to get it manually per disaster.
 */
class ReportDataDeserializer : JsonDeserializer<ReportData> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ):   ReportData{
        json?.let {
            MyLogger.e("Breakpoint 1.")
            val jsonObject = it.asJsonObject
            MyLogger.e("Breakpoint 2 : $jsonObject.")
            val type = jsonObject["report_type"].asString
            MyLogger.e("Breakpoint 3 : $type.")


            return when (type) {
                "flood" -> {
                    val floodDepth = jsonObject["flood_depth"].asInt
                    FloodReportData(type, floodDepth)
                }

                "fire" -> {
                    val fireDistance = jsonObject["fireDistance"].asDouble
                    FireReportData(type, fireDistance)
                }

                "earthquake" -> {
                    EarthquakeReportData(type)
                }

                "haze" -> {
                    HazeReportData(type)
                }

                "wind" -> {
                    WindReportData(type)
                }

                "volcano" -> {
                    VolcanoReportData(type)
                }

                else -> {
                    // Handle any other types or return a default object if needed
                    return EarthquakeReportData("earthquake")
                }
            }
        }
        // Return a default object in case of null JSON or any other errors
        throw IllegalArgumentException("Invalid JSON")
    }
}


sealed class ReportData

data class FloodReportData(
    @field:SerializedName("report_type")
    val reportType: String,
    @field:SerializedName("flood_depth")
    val floodDepth: Int?
) : ReportData()

data class FireReportData(
    @field:SerializedName("report_type")
    val reportType: String,
    @field:SerializedName("fireDistance")
    val fireDistance: Double?
) : ReportData()

data class EarthquakeReportData(
    @field:SerializedName("report_type")
    val reportType: String,
) : ReportData()

data class WindReportData(
    @field:SerializedName("report_type")
    val reportType: String,
) : ReportData()

data class HazeReportData(
    @field:SerializedName("report_type")
    val reportType: String,
) : ReportData()

data class VolcanoReportData(
    @field:SerializedName("report_type")
    val reportType: String,
) : ReportData()
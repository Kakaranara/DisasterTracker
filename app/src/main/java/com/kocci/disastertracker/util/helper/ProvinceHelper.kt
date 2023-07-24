package com.kocci.disastertracker.util.helper

import com.kocci.disastertracker.data.enums.AvailableProvince
import com.kocci.disastertracker.util.exception.ProvinceNotFoundException
import java.lang.Exception
import java.lang.IllegalArgumentException

object ProvinceHelper {
    fun getAvailableProvince(): List<String> {
        val provinceList = AvailableProvince.values().map {
            it.name.lowercase().replace("_", " ")
        }.map { provinceName ->
            provinceName.split(" ").joinToString(" ") { it.replaceFirstChar { it.uppercase() } }
        }
        return provinceList
    }

    fun getProvinceCode(provinceName: String): String {
        try {
            return AvailableProvince.valueOf(
                provinceName.uppercase().replace(" ", "_")
            ).codes
        } catch (e: Exception) {
            throw ProvinceNotFoundException()
        }
    }

}
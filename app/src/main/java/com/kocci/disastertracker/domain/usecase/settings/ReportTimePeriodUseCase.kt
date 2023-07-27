package com.kocci.disastertracker.domain.usecase.settings

interface ReportTimePeriodUseCase {
    fun showTimePeriod(): String
    fun setTimePeriod(period: String)
    fun showAvailableTimePeriod() : Array<String>
}
package com.kocci.disastertracker.domain.usecase.settings

import com.kocci.disastertracker.data.enums.AvailableReportPeriod
import com.kocci.disastertracker.data.source.local.preferences.PreferenceManager
import com.kocci.disastertracker.util.exception.NonsenseException
import javax.inject.Inject

class ReportTimePeriodUseCaseImpl @Inject constructor(
    private val pref: PreferenceManager
) : ReportTimePeriodUseCase {
    override fun showTimePeriod(): String {
        return when (pref.getReportPeriod()) {
            AvailableReportPeriod.ONE_WEEK -> Show.ONE_WEEK
            AvailableReportPeriod.FIVE_DAYS -> Show.FIVE_DAYS
            AvailableReportPeriod.THREE_DAYS -> Show.THREE_DAYS
            AvailableReportPeriod.TWO_DAYS -> Show.TWO_DAYS
            AvailableReportPeriod.TODAY -> Show.TODAY
        }
    }

    override fun setTimePeriod(period: String) {
        val a: AvailableReportPeriod
        when (period) {
            Show.ONE_WEEK -> {
                a = AvailableReportPeriod.ONE_WEEK
            }

            Show.FIVE_DAYS -> {
                a = AvailableReportPeriod.FIVE_DAYS
            }

            Show.THREE_DAYS -> {
                a = AvailableReportPeriod.THREE_DAYS
            }

            Show.TWO_DAYS -> {
                a = AvailableReportPeriod.TWO_DAYS
            }

            Show.TODAY -> {
                a = AvailableReportPeriod.TODAY
            }

            else -> throw NonsenseException("No Period Listed")
        }
        pref.setReportPeriod(a)
    }

    override fun showAvailableTimePeriod(): Array<String> {
        val list = mutableListOf<String>()
        AvailableReportPeriod.values().forEach {
            when (it) {
                AvailableReportPeriod.ONE_WEEK -> {
                    list.add(Show.ONE_WEEK)
                }

                AvailableReportPeriod.FIVE_DAYS -> {
                    list.add(Show.FIVE_DAYS)
                }

                AvailableReportPeriod.THREE_DAYS -> {
                    list.add(Show.THREE_DAYS)
                }

                AvailableReportPeriod.TWO_DAYS -> {
                    list.add(Show.TWO_DAYS)
                }

                AvailableReportPeriod.TODAY -> {
                    list.add(Show.TODAY)
                }
            }
        }
        return list.toTypedArray()
    }

    private object Show {
        const val ONE_WEEK = "Last Week"
        const val FIVE_DAYS = "Last Five Days"
        const val THREE_DAYS = "Last Three Days"
        const val TWO_DAYS = "Last Two Days"
        const val TODAY = "Today"
    }
}
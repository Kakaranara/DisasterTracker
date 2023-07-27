package com.kocci.disastertracker.data.enums

enum class AvailableReportPeriod(val periodInSec: Int) {
    ONE_WEEK(604800),
    FIVE_DAYS(432000),
    THREE_DAYS(259200),
    TWO_DAYS(172800),
    TODAY(86400)
}
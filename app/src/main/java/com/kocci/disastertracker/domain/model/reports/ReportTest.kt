package com.kocci.disastertracker.domain.model.reports

import com.kocci.disastertracker.domain.model.Coordinates

abstract class ReportTest {
    abstract val coordinates: Coordinates
    abstract val title: String
    abstract val body: String
    abstract val date: String
    abstract val imgUrl: String?
    abstract val disasterType: String
}


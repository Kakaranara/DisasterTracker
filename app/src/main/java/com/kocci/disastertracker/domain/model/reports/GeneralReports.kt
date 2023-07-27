package com.kocci.disastertracker.domain.model.reports

import com.kocci.disastertracker.domain.model.Coordinates

data class GeneralReports(
    override val body: String,
    override val coordinates: Coordinates,
    override val imgUrl: String?,
    override val title: String,
    override val disasterType: String,
    override val date: String
) : ReportTest()
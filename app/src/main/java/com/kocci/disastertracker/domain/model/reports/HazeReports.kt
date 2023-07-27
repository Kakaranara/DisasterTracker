package com.kocci.disastertracker.domain.model.reports

import com.kocci.disastertracker.domain.model.Coordinates
import com.kocci.disastertracker.domain.model.Reports

data class HazeReports(
    override val body: String,
    override val coordinates: Coordinates,
    override val imgUrl: String?,
    override val title: String,
    override val disasterType: String,
    override val date: String,
    val reportType: String,
) : Reports()
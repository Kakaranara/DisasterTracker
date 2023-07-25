package com.kocci.disastertracker.domain.model

data class Reports(
    val coordinates: Coordinates,
    val title: String,
    val body: String,
    val date: String,
    val imgUrl: String?,
    val disasterType : String
)

data class Coordinates(
    val lat : Double,
    val lng : Double
)
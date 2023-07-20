package com.kocci.disastertracker.domain.model

data class Reports(
    val coordinates: LatLng,
    val title: String,
    val body: String,
    val date: String,
    val imgUrl: String?
)

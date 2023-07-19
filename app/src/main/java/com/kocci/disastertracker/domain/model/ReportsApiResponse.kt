package com.kocci.disastertracker.domain.model

import com.google.gson.annotations.SerializedName

data class ReportsApiResponse(

	@field:SerializedName("result")
	val result: Result? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null
)

data class Output(

	@field:SerializedName("geometries")
	val geometries: List<GeometriesItem?>? = null,

	@field:SerializedName("type")
	val type: String? = null
)

data class Objects(

	@field:SerializedName("output")
	val output: Output? = null
)

data class Result(

	@field:SerializedName("transform")
	val transform: Transform? = null,

	@field:SerializedName("objects")
	val objects: Objects? = null,

	@field:SerializedName("bbox")
	val bbox: List<Any?>? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("arcs")
	val arcs: List<Any?>? = null
)

data class Transform(

	@field:SerializedName("scale")
	val scale: List<Int?>? = null,

	@field:SerializedName("translate")
	val translate: List<Any?>? = null
)

data class GeometriesItem(

	@field:SerializedName("coordinates")
	val coordinates: List<Double?>? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("properties")
	val properties: Properties? = null
)

data class Tags(

	@field:SerializedName("instance_region_code")
	val instanceRegionCode: String? = null,

	@field:SerializedName("local_area_id")
	val localAreaId: String? = null
)

data class Properties(

	@field:SerializedName("report_data")
	val reportData: Any? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("disaster_type")
	val disasterType: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("pkey")
	val pkey: String? = null,

	@field:SerializedName("source")
	val source: String? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("tags")
	val tags: Tags? = null
)

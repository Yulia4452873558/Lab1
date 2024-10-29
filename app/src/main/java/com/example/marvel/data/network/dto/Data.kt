package com.example.marvel.data.network.dto

import com.squareup.moshi.Json

data class Data(
    @Json(name = "offset") var offset: Int? = null,
    @Json(name = "limit") var limit: Int? = null,
    @Json(name = "total") var total: Int? = null,
    @Json(name = "count") var count: Int? = null,
    @Json(name = "results") var results: List<Results> = listOf()
)

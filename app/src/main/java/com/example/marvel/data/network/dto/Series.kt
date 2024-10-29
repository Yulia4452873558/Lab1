package com.example.marvel.data.network.dto

import com.squareup.moshi.Json

data class Series(
    @Json(name = "available") var available: Int? = null,
    @Json(name = "collectionURI") var collectionURI: String? = null,
    @Json(name = "items") var items: List<Items> = listOf(),
    @Json(name = "returned") var returned: Int? = null
)

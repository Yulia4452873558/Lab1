package com.example.marvel.data.network.dto

import com.squareup.moshi.Json

data class Items_(
    @Json(name = "resourceURI") var resourceURI: String? = null,
    @Json(name = "name") var name: String? = null,
    @Json(name = "type") var type: String? = null
)

package com.example.marvel.data.network.dto

import com.squareup.moshi.Json

data class HeroResponse(
    @Json(name = "code") var code: Int? = null,
    @Json(name = "status") var status: String? = null,
    @Json(name = "copyright") var copyright: String? = null,
    @Json(name = "attributionText") var attributionText: String? = null,
    @Json(name = "attributionHTML") var attributionHTML: String? = null,
    @Json(name = "etag") var etag: String? = null,
    @Json(name = "data") var data: Data? = Data()
)

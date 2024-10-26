package com.example.marvel.data.network.characters

import com.squareup.moshi.Json

data class Thumbnail(
    @Json(name = "path") var path: String? = null,
    @Json(name = "extension") var extension: String? = null
)

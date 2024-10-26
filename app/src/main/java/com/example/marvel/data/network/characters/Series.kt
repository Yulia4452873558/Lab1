package com.example.marvel.data.network.characters

import com.example.marvel.data.network.characters.Items
import com.squareup.moshi.Json

data class Series(
    @Json(name = "available") var available: Int? = null,
    @Json(name = "collectionURI") var collectionURI: String? = null,
    @Json(name = "items") var items: List<Items> = listOf(),
    @Json(name = "returned") var returned: Int? = null
)

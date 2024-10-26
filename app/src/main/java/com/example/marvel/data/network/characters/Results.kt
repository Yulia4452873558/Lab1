package com.example.marvel.data.network.characters

import com.squareup.moshi.Json

data class Results(
    @Json(name = "id") var id: Int? = null,
    @Json(name = "name") var name: String? = null,
    @Json(name = "description") var description: String? = null,
    @Json(name = "modified") var modified: String? = null,
    @Json(name = "thumbnail") var thumbnail: Thumbnail? = Thumbnail(),
    @Json(name = "resourceURI") var resourceURI: String? = null,
    @Json(name = "comics") var comics: Comics? = Comics(),
    @Json(name = "series") var series: Series? = Series(),
    @Json(name = "stories") var stories: Stories? = Stories(),
    @Json(name = "events") var events: Events? = Events(),
    @Json(name = "urls") var urls: List<Urls> = listOf()
)

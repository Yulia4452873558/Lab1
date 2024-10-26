package com.example.marvel.data.network.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


//@JsonClass(generateAdapter = true)
data class HeroResponse(
    @Json(name = "code")
    val code: Int,
    @Json(name = "data")
    val data: Data,
) {

//    @JsonClass(generateAdapter = true)
    data class Data(
        @Json(name = "results")
        val results: List<Superhero>,
    )

//    @JsonClass(generateAdapter = true)
    data class Superhero(
        @Json(name = "id")
        val id: String,
        @Json(name = "name")
        val name: String,
        @Json(name = "description")
        val description: String,
        @Json(name = "thumbnail")
        val image: Image,
    ) {

//        @JsonClass(generateAdapter = true)
        data class Image(
            @Json(name = "path")
            val path: String,
            @Json(name = "extension")
            val extension: String,
        )
    }
}
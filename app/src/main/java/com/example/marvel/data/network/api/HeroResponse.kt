package com.example.marvel.data.network.api

import com.squareup.moshi.Json


data class HeroResponse(
    @Json(name = "code")
    val code: Int,
    @Json(name = "data")
    val data: Data,
) {

    data class Data(
        @Json(name = "results")
        val results: List<Superhero>,
    )

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

        data class Image(
            @Json(name = "path")
            val path: String,
            @Json(name = "extension")
            val extension: String,
        )
    }
}
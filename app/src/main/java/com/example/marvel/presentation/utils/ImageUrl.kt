package com.example.marvel.presentation.utils

import com.example.marvel.data.network.dto.Thumbnail

fun getImageUrl(thumbnail: Thumbnail?): String {
    val imagePath = if (thumbnail?.path?.startsWith("http://")!!) {
        thumbnail.path?.replace("http", "https")
    } else {
        thumbnail.path
    } + "." + thumbnail.extension
    return imagePath
}

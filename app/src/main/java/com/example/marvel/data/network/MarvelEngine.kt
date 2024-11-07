package com.example.marvel.data.network

import com.example.marvel.data.constant.ApiConstants
import com.example.marvel.data.network.api.MarvelApi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun marvelEngine(): MarvelApi {
    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    return Retrofit.Builder()
        .baseUrl(ApiConstants.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(MarvelApi::class.java)
}

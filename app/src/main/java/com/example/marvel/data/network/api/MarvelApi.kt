package com.example.marvel.data.network.api

import com.example.marvel.data.constant.ApiConstants
import com.example.marvel.data.network.characters.CharacterRoot
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {

    @GET("/v1/public/characters")
    suspend fun getSuperheroes(
        @Query("limit") limit: String = ApiConstants.LIMIT,
        @Query("apikey") apiKey: String = ApiConstants.PUBLIC_API_KEY,
        @Query("ts") timeStamp: String = ApiConstants.TIMESTAMP,
        @Query("hash") hash: String = ApiConstants.generateHash(),
    ): CharacterRoot


    @GET("characters/{id}")
    suspend fun getSuperhero(
        @Path("id") heroId: String,
        @Query("apikey") apiKey: String = ApiConstants.PUBLIC_API_KEY,
        @Query("ts") timeStamp: String = ApiConstants.TIMESTAMP,
        @Query("hash") hash: String = ApiConstants.generateHash(),
    ): CharacterRoot
}

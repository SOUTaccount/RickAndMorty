package com.stebakov.homescreen.data.cloud.service

import com.stebakov.homescreen.data.cloud.entity.Characters
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersService {

    @GET("character")
    suspend fun getCharacterPage(
        @Query("page") page: Int? = null,
        @Query("name") name: String? = null,
        @Query("status") status: String? = null,
        @Query("species") species: String? = null,
        @Query("gender") gender: String? = null
    ): Characters

    //TODO add pagination
}
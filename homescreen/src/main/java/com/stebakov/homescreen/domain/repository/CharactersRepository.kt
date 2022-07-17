package com.stebakov.homescreen.domain.repository

import com.stebakov.homescreen.data.model.ListCharactersDetailsData

interface CharactersRepository {
    suspend fun getCharacters(
        page: Int? = null,
        name: String? = null,
        status: String? = null,
        species: String? = null,
        gender: String? = null
    ): ListCharactersDetailsData
}
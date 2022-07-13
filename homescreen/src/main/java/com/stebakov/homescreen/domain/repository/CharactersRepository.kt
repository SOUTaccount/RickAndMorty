package com.stebakov.homescreen.domain.repository

import com.stebakov.homescreen.data.model.ListCharactersDetailsData

interface CharactersRepository {
    suspend fun getCharacters(): ListCharactersDetailsData
}
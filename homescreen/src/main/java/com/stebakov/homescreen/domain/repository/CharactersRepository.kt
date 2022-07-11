package com.stebakov.homescreen.domain.repository

import com.stebakov.homescreen.data.ListCharactersDetailsData

interface CharactersRepository {
    suspend fun getCharacters(): ListCharactersDetailsData
}
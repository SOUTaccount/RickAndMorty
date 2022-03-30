package com.stebakov.homescreen.domain.repository

import com.stebakov.homescreen.data.entity.Characters

interface CharactersRepository {
    suspend fun getCharacters(): Characters
}
package com.stebakov.homescreen.domain.repository

interface CharactersRepository {
    suspend fun getCharacters()
}
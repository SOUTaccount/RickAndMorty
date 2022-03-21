package com.stebakov.homescreen.data.network

import com.stebakov.homescreen.domain.repository.CharactersRepository
import javax.inject.Inject

class CharactersRepositoryImpl
@Inject constructor(private val charactersService: CharactersService) : CharactersRepository {
    override suspend fun getCharacters() {
        TODO("Not yet implemented")
    }
}
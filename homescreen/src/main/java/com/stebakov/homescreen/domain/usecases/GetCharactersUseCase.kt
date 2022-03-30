package com.stebakov.homescreen.domain.usecases

import com.stebakov.homescreen.data.network.CharactersRepositoryImpl
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val repository: CharactersRepositoryImpl) {
    suspend fun getCharacters() = repository.getCharacters()
}
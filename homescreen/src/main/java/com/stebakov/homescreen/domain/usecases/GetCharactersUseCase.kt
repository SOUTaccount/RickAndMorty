package com.stebakov.homescreen.domain.usecases

import com.stebakov.homescreen.data.mappers.ListCharactersDataToDomainMapper
import com.stebakov.homescreen.domain.model.ListCharactersDetailsDomain
import com.stebakov.homescreen.domain.repository.CharactersRepository
import javax.inject.Inject

interface GetCharactersUseCase {
    suspend fun getCharacters(): ListCharactersDetailsDomain

    class Base @Inject constructor(
        private val repository: CharactersRepository,
        private val mapper: ListCharactersDataToDomainMapper
    ) : GetCharactersUseCase {
        override suspend fun getCharacters() = repository.getCharacters().map(mapper = mapper)
    }
}
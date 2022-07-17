package com.stebakov.homescreen.domain.usecases

import com.stebakov.homescreen.data.mappers.ListCharactersDataToDomainMapper
import com.stebakov.homescreen.domain.model.ListCharactersDetailsDomain
import com.stebakov.homescreen.domain.repository.CharactersRepository
import javax.inject.Inject

interface GetCharactersUseCase {
    suspend fun getCharacters(
        page: Int? = null,
        name: String? = null,
        status: String? = null,
        species: String? = null,
        gender: String? = null
    ): ListCharactersDetailsDomain

    class Base @Inject constructor(
        private val repository: CharactersRepository,
        private val mapper: ListCharactersDataToDomainMapper
    ) : GetCharactersUseCase {
        override suspend fun getCharacters(
            page: Int?,
            name: String?,
            status: String?,
            species: String?,
            gender: String?
        ) = repository.getCharacters(page, name, status, species, gender).map(mapper = mapper)
    }
}
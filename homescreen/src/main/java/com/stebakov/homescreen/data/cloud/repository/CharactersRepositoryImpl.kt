package com.stebakov.homescreen.data.cloud.repository

import com.stebakov.homescreen.data.model.ListCharactersDetailsData
import com.stebakov.homescreen.data.cloud.CharactersCloudMapper
import com.stebakov.homescreen.data.cloud.service.CharactersService
import com.stebakov.homescreen.domain.repository.CharactersRepository
import java.lang.Exception
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val charactersService: CharactersService,
    private val cloudMapper: CharactersCloudMapper
) : CharactersRepository {
    override suspend fun getCharacters(
        page: Int?,
        name: String?,
        status: String?,
        species: String?,
        gender: String?
    ) = try {
        val characters = charactersService.getCharacterPage(page, name, status, species, gender)
        val characterDetails = characters.map(cloudMapper)
        ListCharactersDetailsData.Success(characterDetails)
    } catch (e: Exception) {
        ListCharactersDetailsData.Fail(e)
    }
}
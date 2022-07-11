package com.stebakov.homescreen.data.cloud

import com.stebakov.homescreen.data.ListCharactersDetailsData
import com.stebakov.homescreen.domain.repository.CharactersRepository
import java.lang.Exception
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val charactersService: CharactersService,
    private val cloudMapper: CharactersCloudMapper
) : CharactersRepository {
    override suspend fun getCharacters() = try {
        val characters = charactersService.getCharacterPage()
        val characterDetails = characters.map(cloudMapper)
        ListCharactersDetailsData.Success(characterDetails)
    } catch (e: Exception) {
        ListCharactersDetailsData.Fail(e)
    }
}
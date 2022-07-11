package com.stebakov.homescreen.domain

import com.stebakov.homescreen.data.CharactersDataToDomainMapper
import com.stebakov.homescreen.data.CharactersDetailsData
import com.stebakov.homescreen.data.ListCharactersDataToDomainMapper
import java.lang.Exception
import javax.inject.Inject

class BaseListCharactersDataToDomainMapper @Inject constructor(private val charactersMapper: CharactersDataToDomainMapper) :
    ListCharactersDataToDomainMapper() {
    override fun map(e: Exception): ListCharactersDetailsDomain =
        ListCharactersDetailsDomain.Fail(errorType(e))


    override fun map(data: List<CharactersDetailsData>): ListCharactersDetailsDomain {
        val domainList = data.map { charactersData ->
            charactersData.map(charactersMapper)
        }
        return ListCharactersDetailsDomain.Success(domainList)
    }
}
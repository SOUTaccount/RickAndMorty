package com.stebakov.homescreen.domain.mappers

import com.stebakov.homescreen.data.mappers.CharactersDataToDomainMapper
import com.stebakov.homescreen.data.model.CharactersDetailsData
import com.stebakov.homescreen.data.mappers.ListCharactersDataToDomainMapper
import com.stebakov.homescreen.domain.model.ListCharactersDetailsDomain
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
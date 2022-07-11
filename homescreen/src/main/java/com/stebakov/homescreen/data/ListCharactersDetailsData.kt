package com.stebakov.homescreen.data

import com.stebakov.core.Abstract
import com.stebakov.homescreen.domain.ListCharactersDetailsDomain
import java.lang.Exception

sealed class ListCharactersDetailsData :
    Abstract.Object<ListCharactersDetailsDomain, ListCharactersDataToDomainMapper> {

    data class Success(private val characters: List<CharactersDetailsData>) :
        ListCharactersDetailsData() {
        override fun map(mapper: ListCharactersDataToDomainMapper): ListCharactersDetailsDomain {
            return mapper.map(characters)
        }
    }

    data class Fail(private val e: Exception) : ListCharactersDetailsData() {
        override fun map(mapper: ListCharactersDataToDomainMapper): ListCharactersDetailsDomain {
            return mapper.map(e)
        }
    }
}
package com.stebakov.homescreen.domain

import com.stebakov.core.Abstract
import com.stebakov.core.ErrorType
import com.stebakov.homescreen.presentation.ListCharactersDetailsUi

sealed class ListCharactersDetailsDomain :
    Abstract.Object<ListCharactersDetailsUi, ListCharactersDomainToUiMapper> {

    data class Success(private val characters: List<CharactersDetailsDomain>) :
        ListCharactersDetailsDomain() {
        override fun map(mapper: ListCharactersDomainToUiMapper): ListCharactersDetailsUi {
            return mapper.map(characters)
        }
    }

    data class Fail(private val errorType: ErrorType) : ListCharactersDetailsDomain() {
        override fun map(mapper: ListCharactersDomainToUiMapper): ListCharactersDetailsUi {
            return mapper.map(errorType)
        }
    }
}
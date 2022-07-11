package com.stebakov.homescreen.presentation

import com.stebakov.core.ErrorType
import com.stebakov.core.ResourceProvider
import com.stebakov.homescreen.domain.CharactersDetailsDomain
import com.stebakov.homescreen.domain.CharactersDetailsDomainToUiMapper
import com.stebakov.homescreen.domain.ListCharactersDomainToUiMapper
import javax.inject.Inject

class BaseListCharactersDomainToUiMapper @Inject constructor(
    resourceProvider: ResourceProvider,
    private val mapper: CharactersDetailsDomainToUiMapper
) : ListCharactersDomainToUiMapper(resourceProvider) {
    override fun map(errorType: ErrorType) =
        ListCharactersDetailsUi.Base(listOf(CharactersDetailsUi.Fail(errorMessage(errorType))))

    override fun map(data: List<CharactersDetailsDomain>) = ListCharactersDetailsUi.Base(data.map {
        it.map(mapper)
    })
}
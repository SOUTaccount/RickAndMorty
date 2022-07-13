package com.stebakov.homescreen.presentation.mappers

import com.stebakov.core.ErrorType
import com.stebakov.core.ResourceProvider
import com.stebakov.homescreen.domain.model.CharactersDetailsDomain
import com.stebakov.homescreen.domain.mappers.CharactersDetailsDomainToUiMapper
import com.stebakov.homescreen.domain.mappers.ListCharactersDomainToUiMapper
import com.stebakov.homescreen.presentation.model.CharactersDetailsUi
import com.stebakov.homescreen.presentation.model.ListCharactersDetailsUi
import javax.inject.Inject

class BaseListCharactersDomainToUiMapper @Inject constructor(
    private val resourceProvider: ResourceProvider,
    private val mapper: CharactersDetailsDomainToUiMapper
) : ListCharactersDomainToUiMapper(resourceProvider) {
    override fun map(errorType: ErrorType) =
        ListCharactersDetailsUi.Base(listOf(CharactersDetailsUi.Fail(errorMessage(errorType))))

    override fun map(data: List<CharactersDetailsDomain>) = ListCharactersDetailsUi.Base(data.map {
        it.map(mapper)
    })
}
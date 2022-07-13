package com.stebakov.homescreen.domain.mappers

import com.stebakov.core.Abstract
import com.stebakov.core.ResourceProvider
import com.stebakov.homescreen.domain.model.CharactersDetailsDomain
import com.stebakov.homescreen.presentation.model.ListCharactersDetailsUi

abstract class ListCharactersDomainToUiMapper(resourceProvider: ResourceProvider) :
    Abstract.Mapper.DomainToUi.Base<List<CharactersDetailsDomain>,
            ListCharactersDetailsUi>(resourceProvider)
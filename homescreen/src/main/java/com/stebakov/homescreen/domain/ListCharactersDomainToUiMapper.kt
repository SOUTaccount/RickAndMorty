package com.stebakov.homescreen.domain

import com.stebakov.core.Abstract
import com.stebakov.core.ResourceProvider
import com.stebakov.homescreen.presentation.ListCharactersDetailsUi

abstract class ListCharactersDomainToUiMapper(resourceProvider: ResourceProvider) :
    Abstract.Mapper.DomainToUi.Base<List<CharactersDetailsDomain>,
            ListCharactersDetailsUi>(resourceProvider)
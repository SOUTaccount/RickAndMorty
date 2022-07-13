package com.stebakov.homescreen.data.mappers

import com.stebakov.core.Abstract
import com.stebakov.homescreen.data.model.CharactersDetailsData
import com.stebakov.homescreen.domain.model.ListCharactersDetailsDomain

abstract class ListCharactersDataToDomainMapper :
    Abstract.Mapper.DataToDomain.Base<List<CharactersDetailsData>, ListCharactersDetailsDomain>() {
}
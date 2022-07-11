package com.stebakov.homescreen.data

import com.stebakov.core.Abstract
import com.stebakov.homescreen.domain.ListCharactersDetailsDomain

abstract class ListCharactersDataToDomainMapper :
    Abstract.Mapper.DataToDomain.Base<List<CharactersDetailsData>, ListCharactersDetailsDomain>() {
}
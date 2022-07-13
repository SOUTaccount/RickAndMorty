package com.stebakov.homescreen.data.mappers

import com.stebakov.core.Abstract
import com.stebakov.homescreen.domain.model.CharactersDetailsDomain

interface CharactersDataToDomainMapper : Abstract.Mapper {
    fun map(
        id: Int,
        name: String,
        status: String,
        species: String,
        type: String,
        gender: String,
        image: String,
        episode: List<String>
    ) : CharactersDetailsDomain
}
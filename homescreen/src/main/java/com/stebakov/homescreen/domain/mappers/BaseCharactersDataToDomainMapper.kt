package com.stebakov.homescreen.domain.mappers

import com.stebakov.homescreen.data.mappers.CharactersDataToDomainMapper
import com.stebakov.homescreen.domain.model.CharactersDetailsDomain
import javax.inject.Inject

class BaseCharactersDataToDomainMapper @Inject constructor() : CharactersDataToDomainMapper {
    override fun map(
        id: Int,
        name: String,
        status: String,
        species: String,
        type: String,
        gender: String,
        image: String,
        episode: List<String>
    ) = CharactersDetailsDomain(id, name, status, species, type, gender, image, episode)
}
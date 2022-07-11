package com.stebakov.homescreen.domain

import com.stebakov.homescreen.data.CharactersDataToDomainMapper

class BaseCharactersDataToDomainMapper : CharactersDataToDomainMapper {
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
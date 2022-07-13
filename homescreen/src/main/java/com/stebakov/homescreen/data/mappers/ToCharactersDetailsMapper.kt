package com.stebakov.homescreen.data.mappers

import com.stebakov.core.Abstract
import com.stebakov.homescreen.data.model.CharactersDetailsData
import javax.inject.Inject

interface ToCharactersDetailsMapper : Abstract.Mapper {
    fun map(
        id: Int,
        name: String,
        status: String,
        species: String,
        type: String,
        gender: String,
        image: String,
        episode: List<String>
    ): CharactersDetailsData

    class Base @Inject constructor() : ToCharactersDetailsMapper {
        override fun map(
            id: Int,
            name: String,
            status: String,
            species: String,
            type: String,
            gender: String,
            image: String,
            episode: List<String>
        ) = CharactersDetailsData(id, name, status, species, type, gender, image, episode)
    }
}

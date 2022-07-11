package com.stebakov.homescreen.data

import com.stebakov.core.Abstract
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

package com.stebakov.homescreen.data

import com.stebakov.core.Abstract
import com.stebakov.homescreen.domain.CharactersDetailsDomain


data class CharactersDetailsData(
    private val id: Int,
    private val name: String,
    private val status: String,
    private val species: String,
    private val type: String,
    private val gender: String,
    private val image: String,
    private val episode: List<String>
) : Abstract.Object<CharactersDetailsDomain, CharactersDataToDomainMapper> {
    override fun map(mapper: CharactersDataToDomainMapper) =
        mapper.map(id, name, status, species, type, gender, image, episode)
}
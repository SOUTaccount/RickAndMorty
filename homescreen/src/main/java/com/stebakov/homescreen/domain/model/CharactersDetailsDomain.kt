package com.stebakov.homescreen.domain.model

import com.stebakov.core.Abstract
import com.stebakov.homescreen.domain.mappers.CharactersDetailsDomainToUiMapper
import com.stebakov.homescreen.presentation.model.CharactersDetailsUi

data class CharactersDetailsDomain(
    private val id: Int,
    private val name: String,
    private val status: String,
    private val species: String,
    private val type: String,
    private val gender: String,
    private val image: String,
    private val episode: List<String>
) : Abstract.Object<CharactersDetailsUi, CharactersDetailsDomainToUiMapper> {
    override fun map(mapper: CharactersDetailsDomainToUiMapper) =
        mapper.map(id, name, status, species, type, gender, image, episode)
}
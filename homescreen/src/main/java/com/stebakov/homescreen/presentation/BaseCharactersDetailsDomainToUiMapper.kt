package com.stebakov.homescreen.presentation

import com.stebakov.homescreen.domain.CharactersDetailsDomainToUiMapper
import javax.inject.Inject

class BaseCharactersDetailsDomainToUiMapper @Inject constructor() : CharactersDetailsDomainToUiMapper {
    override fun map(
        id: Int,
        name: String,
        status: String,
        species: String,
        type: String,
        gender: String,
        image: String,
        episode: List<String>
    ) = CharactersDetailsUi.Base(id, name, status, species, type, gender, image, episode)
}
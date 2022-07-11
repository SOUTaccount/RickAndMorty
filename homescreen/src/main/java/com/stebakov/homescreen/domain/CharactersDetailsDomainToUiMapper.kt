package com.stebakov.homescreen.domain

import com.stebakov.core.Abstract
import com.stebakov.homescreen.presentation.CharactersDetailsUi

interface CharactersDetailsDomainToUiMapper : Abstract.Mapper {
    fun map(
        id: Int,
        name: String,
        status: String,
        species: String,
        type: String,
        gender: String,
        image: String,
        episode: List<String>
    ): CharactersDetailsUi
}
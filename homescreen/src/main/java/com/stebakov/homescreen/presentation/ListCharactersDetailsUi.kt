package com.stebakov.homescreen.presentation

import com.stebakov.core.Abstract

sealed class ListCharactersDetailsUi : Abstract.Object<Unit, CharactersCommunication> {
    data class Base(private val characters: List<CharactersDetailsUi>) : ListCharactersDetailsUi() {
        override fun map(mapper: CharactersCommunication) = mapper.map(data = characters)
    }
}
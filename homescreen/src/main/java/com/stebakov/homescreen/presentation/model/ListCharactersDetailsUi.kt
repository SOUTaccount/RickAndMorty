package com.stebakov.homescreen.presentation.model

import com.stebakov.core.Abstract
import com.stebakov.homescreen.presentation.CharactersCommunication

sealed class ListCharactersDetailsUi : Abstract.Object<Unit, CharactersCommunication> {
    data class Base(private val characters: List<CharactersDetailsUi>) : ListCharactersDetailsUi() {
        override fun map(mapper: CharactersCommunication) = mapper.map(data = characters)
    }
}
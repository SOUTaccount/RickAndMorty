package com.stebakov.homescreen.presentation.model

import com.stebakov.core.Abstract
import com.stebakov.homescreen.presentation.CharactersCommunication
import com.stebakov.homescreen.presentation.mappers.NewDataMapper

sealed class ListCharactersDetailsUi : Abstract.Object<Unit, CharactersCommunication>,
    NewDataMapper<CharactersCommunication> {
    data class Base(private val characters: List<CharactersDetailsUi>) : ListCharactersDetailsUi() {
        override fun map(mapper: CharactersCommunication) = mapper.map(data = characters)
        override fun mapNewData(mapper: CharactersCommunication) = mapper.mapNewData(characters)
    }
}
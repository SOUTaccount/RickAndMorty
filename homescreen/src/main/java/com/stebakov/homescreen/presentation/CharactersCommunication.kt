package com.stebakov.homescreen.presentation

import com.stebakov.core.Communication
import com.stebakov.homescreen.presentation.model.CharactersDetailsUi
import javax.inject.Inject

interface CharactersCommunication : Communication<List<CharactersDetailsUi>> {
    class Base @Inject constructor() : CharactersCommunication,
        Communication.Base<List<CharactersDetailsUi>>() {
        private val currentData = mutableListOf<CharactersDetailsUi>()
        override fun map(data: List<CharactersDetailsUi>) {
            if (currentData.isNotEmpty() && currentData.first() is CharactersDetailsUi.Fail) {
                currentData.clear()
            }
            if (data.first() !is CharactersDetailsUi.Fail && data.first() !is CharactersDetailsUi.Progress)
                currentData.addAll(data)
            else currentData.clear()
            super.map(data)
        }

        override fun mapNewData(data: List<CharactersDetailsUi>) {
            if (data.first() is CharactersDetailsUi.Fail) {
                currentData.clear()
                currentData.addAll(data)
            } else {
                currentData.addAll(data)
            }
            super.mapNewData(currentData)
        }
    }
}
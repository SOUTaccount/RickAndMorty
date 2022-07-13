package com.stebakov.homescreen.presentation

import com.stebakov.core.Communication
import com.stebakov.homescreen.presentation.model.CharactersDetailsUi
import javax.inject.Inject

interface CharactersCommunication : Communication<List<CharactersDetailsUi>> {
    class Base @Inject constructor() : CharactersCommunication,
        Communication.Base<List<CharactersDetailsUi>>()
}
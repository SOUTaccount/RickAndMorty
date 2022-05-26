package com.stebakov.homescreen.presentation.viewmodel

import com.stebakov.core.base.BaseModel
import com.stebakov.homescreen.data.entity.Characters
import com.stebakov.homescreen.domain.usecases.GetCharactersUseCase
import javax.inject.Inject

interface HomeScreenModel : BaseModel {
    suspend fun getCloudData(): Characters

    class Base @Inject constructor
        (private val getCharactersUseCase: GetCharactersUseCase) : HomeScreenModel {
        override suspend fun getCloudData() = getCharactersUseCase.getCharacters()
    }
}
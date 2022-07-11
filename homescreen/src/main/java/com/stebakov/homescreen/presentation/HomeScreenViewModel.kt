package com.stebakov.homescreen.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.stebakov.core.base.BaseViewModel
import com.stebakov.homescreen.domain.CharactersDetailsDomainToUiMapper
import com.stebakov.homescreen.domain.ListCharactersDomainToUiMapper
import com.stebakov.homescreen.domain.usecases.GetCharactersUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeScreenViewModel @Inject constructor(
    private val communication: CharactersCommunication,
    private val mapper: ListCharactersDomainToUiMapper,
    private val charactersUseCase: GetCharactersUseCase
) : BaseViewModel() {

    fun fetchCharacters() {
        communication.map(listOf(CharactersDetailsUi.Progress))
        viewModelScope.launch(Dispatchers.IO){
            val resultDomain = charactersUseCase.getCharacters()
            val resultUi = resultDomain.map(mapper = mapper)
            withContext(Dispatchers.Main){
                resultUi.map(communication)
            }
        }
    }

    fun observe(owner: LifecycleOwner, observer: Observer<List<CharactersDetailsUi>>){
        communication.observe(owner, observer)
    }
}
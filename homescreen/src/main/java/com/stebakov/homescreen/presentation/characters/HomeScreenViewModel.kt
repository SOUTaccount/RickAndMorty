package com.stebakov.homescreen.presentation.characters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.stebakov.core.base.BaseViewModel
import com.stebakov.homescreen.domain.mappers.ListCharactersDomainToUiMapper
import com.stebakov.homescreen.domain.usecases.GetCharactersUseCase
import com.stebakov.homescreen.presentation.CharactersCommunication
import com.stebakov.homescreen.presentation.model.CharactersDetailsUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeScreenViewModel @Inject constructor(
    private val communication: CharactersCommunication,
    private val mapper: ListCharactersDomainToUiMapper,
    private val charactersUseCase: GetCharactersUseCase
) : BaseViewModel() {

    private var currentPage = 1

    fun fetchCharacters(
        page: Int? = null,
        name: String? = null,
        status: String? = null,
        species: String? = null,
        gender: String? = null
    ) {
        communication.map(listOf(CharactersDetailsUi.Progress))
        viewModelScope.launch(Dispatchers.IO) {
            val resultDomain = charactersUseCase.getCharacters(page, name, status, species, gender)
            val resultUi = resultDomain.map(mapper = mapper)
            withContext(Dispatchers.Main) {
                resultUi.map(communication)
            }
        }
    }

    fun fetchNextPage() {
        currentPage++
        viewModelScope.launch(Dispatchers.IO) {
            val resultDomain = charactersUseCase.getCharacters(page = currentPage)
            val resultUi = resultDomain.map(mapper = mapper)
            withContext(Dispatchers.Main) {
                resultUi.mapNewData(communication)
            }
        }
    }

    fun observe(owner: LifecycleOwner, observer: Observer<List<CharactersDetailsUi>>) {
        communication.observe(owner, observer)
    }
}
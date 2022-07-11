package com.stebakov.rickandmorty.di

import com.stebakov.homescreen.domain.usecases.GetCharactersUseCase
import com.stebakov.homescreen.presentation.BaseListCharactersDomainToUiMapper
import com.stebakov.homescreen.presentation.CharactersCommunication
import com.stebakov.homescreen.presentation.HomeScreenViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun provideHomeScreenViewModel(
        communication: CharactersCommunication.Base,
        mapper: BaseListCharactersDomainToUiMapper,
        useCase: GetCharactersUseCase.Base
    ) = HomeScreenViewModel(communication, mapper, useCase)

}
package com.stebakov.homescreen.di

import com.stebakov.homescreen.domain.mappers.ListCharactersDomainToUiMapper
import com.stebakov.homescreen.domain.usecases.GetCharactersUseCase
import com.stebakov.homescreen.presentation.CharactersCommunication
import com.stebakov.homescreen.presentation.characters.HomeScreenViewModel
import dagger.Module
import dagger.Provides

@Module
class HomeScreenCoreModule {

    @Provides
    fun provideHomeScreenViewModel(
        communication: CharactersCommunication,
        mapper: ListCharactersDomainToUiMapper,
        useCase: GetCharactersUseCase
    ) = HomeScreenViewModel(communication, mapper, useCase)
}
package com.stebakov.homescreen.di

import com.stebakov.homescreen.data.cloud.repository.CharactersRepositoryImpl
import com.stebakov.homescreen.domain.repository.CharactersRepository
import com.stebakov.homescreen.domain.usecases.GetCharactersUseCase
import com.stebakov.homescreen.presentation.CharactersCommunication
import dagger.Binds
import dagger.Module

@Module
interface HomeScreenModule {

    @Binds
    fun homeScreenFeature(homeScreenFeature: HomeScreenFeature.Base): HomeScreenFeature

    @Binds
    fun charactersRepository(charactersRepositoryImpl: CharactersRepositoryImpl): CharactersRepository

    @Binds
    fun provideCharactersCommunication(charactersCommunication: CharactersCommunication.Base): CharactersCommunication

    @Binds
    fun provideGetCharactersUseCase(getCharactersUseCase: GetCharactersUseCase.Base): GetCharactersUseCase

}
package com.stebakov.rickandmorty.di

import com.stebakov.homescreen.data.network.CharactersRepositoryImpl
import com.stebakov.homescreen.domain.usecases.GetCharactersUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetCharactersUseCase(repository: CharactersRepositoryImpl) =
        GetCharactersUseCase(repository = repository)
}
package com.stebakov.rickandmorty.di

import com.stebakov.homescreen.data.cloud.CharactersRepositoryImpl
import com.stebakov.homescreen.domain.BaseListCharactersDataToDomainMapper
import com.stebakov.homescreen.domain.usecases.GetCharactersUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetCharactersUseCase(
        repository: CharactersRepositoryImpl,
        mapper: BaseListCharactersDataToDomainMapper
    ) = GetCharactersUseCase.Base(repository = repository, mapper = mapper)
}
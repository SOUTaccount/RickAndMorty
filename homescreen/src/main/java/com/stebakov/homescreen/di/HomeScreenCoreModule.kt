package com.stebakov.homescreen.di

import com.stebakov.core.ResourceProvider
import com.stebakov.homescreen.data.CharactersDataToDomainMapper
import com.stebakov.homescreen.data.ListCharactersDataToDomainMapper
import com.stebakov.homescreen.data.ToCharactersDetailsMapper
import com.stebakov.homescreen.data.cloud.CharactersCloudMapper
import com.stebakov.homescreen.data.cloud.CharactersRepositoryImpl
import com.stebakov.homescreen.domain.BaseCharactersDataToDomainMapper
import com.stebakov.homescreen.domain.BaseListCharactersDataToDomainMapper
import com.stebakov.homescreen.domain.CharactersDetailsDomainToUiMapper
import com.stebakov.homescreen.domain.ListCharactersDomainToUiMapper
import com.stebakov.homescreen.domain.repository.CharactersRepository
import com.stebakov.homescreen.domain.usecases.GetCharactersUseCase
import com.stebakov.homescreen.presentation.BaseCharactersDetailsDomainToUiMapper
import com.stebakov.homescreen.presentation.BaseListCharactersDomainToUiMapper
import com.stebakov.homescreen.presentation.CharactersCommunication
import com.stebakov.homescreen.presentation.HomeScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class HomeScreenCoreModule {

//    @HomeScreenScope
//    @Provides
//    fun provideCharactersCommunication() = CharactersCommunication.Base()

//    @HomeScreenScope
//    @Provides
//    fun provideListCharactersDomainToUiMapper(
//        resourceProvider: ResourceProvider,
//        mapper: CharactersDetailsDomainToUiMapper
//    ) = BaseListCharactersDomainToUiMapper(resourceProvider, mapper)

//    @HomeScreenScope
//    @Provides
//    fun provideToCharactersDetailsMapper() = ToCharactersDetailsMapper.Base()

//    @HomeScreenScope
//    @Provides
//    fun provideCharactersCloudMapper(mapper: ToCharactersDetailsMapper) =
//        CharactersCloudMapper.Base(mapper)

//    @HomeScreenScope
//    @Provides
//    fun provideBaseListCharactersDataToDomainMapper(charactersMapper: CharactersDataToDomainMapper) =
//        BaseListCharactersDataToDomainMapper(charactersMapper)

    @HomeScreenScope
    @Provides
    fun provideCharactersDataToDomainMapper() = BaseCharactersDataToDomainMapper()

//    @HomeScreenScope
//    @Provides
//    fun provideGetCharactersUseCase(
//        repository: CharactersRepository,
//        mapper: ListCharactersDataToDomainMapper
//    ) = GetCharactersUseCase.Base(repository = repository, mapper = mapper)

    @Provides
    fun provideHomeScreenViewModel(
        communication: CharactersCommunication,
        mapper: ListCharactersDomainToUiMapper,
        useCase: GetCharactersUseCase
    ) = HomeScreenViewModel(communication, mapper, useCase)
}
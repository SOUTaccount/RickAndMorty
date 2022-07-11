package com.stebakov.homescreen.di

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
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface HomeScreenModule {

    @Binds
    fun homeScreenFeature(homeScreenFeature: HomeScreenFeature.Base): HomeScreenFeature

    @Binds
    fun charactersRepository(charactersRepositoryImpl: CharactersRepositoryImpl): CharactersRepository

    @Binds
    fun provideCharactersCommunication(charactersCommunication: CharactersCommunication.Base): CharactersCommunication

    @Binds
    fun provideListCharactersDomainToUiMapper(listCharactersDomainToUiMapper: BaseListCharactersDomainToUiMapper): ListCharactersDomainToUiMapper

    @Binds
    fun provideGetCharactersUseCase(getCharactersUseCase: GetCharactersUseCase.Base): GetCharactersUseCase

    @Binds
    fun provideCharacterDetailsDomainToUiMapper(charactersDetailsDomainToUiMapper: BaseCharactersDetailsDomainToUiMapper): CharactersDetailsDomainToUiMapper

    @Binds
    fun provideBaseListCharactersDataToDomainMapper(charactersMapper: BaseListCharactersDataToDomainMapper): ListCharactersDataToDomainMapper

    @Binds
    fun provideCharactersCloudMapper(mapper: CharactersCloudMapper.Base): CharactersCloudMapper

    @Binds
    fun provideToCharactersDetailsMapper(toCharactersDetailsMapper: ToCharactersDetailsMapper.Base) : ToCharactersDetailsMapper

    @Binds
    fun provideCharactersDataToDomainMapper(charactersDataToDomainMapper: BaseCharactersDataToDomainMapper) : CharactersDataToDomainMapper
}
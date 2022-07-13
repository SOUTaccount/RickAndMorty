package com.stebakov.homescreen.di

import com.stebakov.homescreen.data.mappers.CharactersDataToDomainMapper
import com.stebakov.homescreen.data.mappers.ListCharactersDataToDomainMapper
import com.stebakov.homescreen.data.mappers.ToCharactersDetailsMapper
import com.stebakov.homescreen.data.cloud.CharactersCloudMapper
import com.stebakov.homescreen.domain.mappers.BaseCharactersDataToDomainMapper
import com.stebakov.homescreen.domain.mappers.BaseListCharactersDataToDomainMapper
import com.stebakov.homescreen.domain.mappers.CharactersDetailsDomainToUiMapper
import com.stebakov.homescreen.domain.mappers.ListCharactersDomainToUiMapper
import com.stebakov.homescreen.presentation.mappers.BaseCharactersDetailsDomainToUiMapper
import com.stebakov.homescreen.presentation.mappers.BaseListCharactersDomainToUiMapper
import dagger.Binds
import dagger.Module

@Module
interface HomeScreenMapperModule {

    @Binds
    fun provideCharacterDetailsDomainToUiMapper(charactersDetailsDomainToUiMapper: BaseCharactersDetailsDomainToUiMapper): CharactersDetailsDomainToUiMapper

    @Binds
    fun provideBaseListCharactersDataToDomainMapper(charactersMapper: BaseListCharactersDataToDomainMapper): ListCharactersDataToDomainMapper

    @Binds
    fun provideCharactersCloudMapper(mapper: CharactersCloudMapper.Base): CharactersCloudMapper

    @Binds
    fun provideToCharactersDetailsMapper(toCharactersDetailsMapper: ToCharactersDetailsMapper.Base): ToCharactersDetailsMapper

    @Binds
    fun provideCharactersDataToDomainMapper(charactersDataToDomainMapper: BaseCharactersDataToDomainMapper): CharactersDataToDomainMapper

    @Binds
    fun provideListCharactersDomainToUiMapper(listCharactersDomainToUiMapper: BaseListCharactersDomainToUiMapper): ListCharactersDomainToUiMapper

}
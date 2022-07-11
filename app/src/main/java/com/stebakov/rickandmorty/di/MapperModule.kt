package com.stebakov.rickandmorty.di

import com.stebakov.core.ResourceProvider
import com.stebakov.homescreen.data.CharactersDataToDomainMapper
import com.stebakov.homescreen.data.ToCharactersDetailsMapper
import com.stebakov.homescreen.data.cloud.CharactersCloudMapper
import com.stebakov.homescreen.domain.BaseCharactersDataToDomainMapper
import com.stebakov.homescreen.domain.BaseListCharactersDataToDomainMapper
import com.stebakov.homescreen.presentation.BaseCharactersDetailsDomainToUiMapper
import com.stebakov.homescreen.presentation.BaseListCharactersDomainToUiMapper
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @Provides
    fun provideListCharactersDomainToUiMapper(
        resourceProvider: ResourceProvider.Base,
        mapper: BaseCharactersDetailsDomainToUiMapper
    ) = BaseListCharactersDomainToUiMapper(resourceProvider, mapper)

    @Provides
    fun provideToCharactersDetailsMapper() = ToCharactersDetailsMapper.Base()

    @Provides
    fun provideCharactersCloudMapper(mapper: ToCharactersDetailsMapper.Base) =
        CharactersCloudMapper.Base(mapper)

    @Provides
    fun provideBaseListCharactersDataToDomainMapper(charactersMapper: BaseCharactersDataToDomainMapper) =
        BaseListCharactersDataToDomainMapper(charactersMapper)

    @Provides
    fun provideCharactersDataToDomainMapper() = BaseCharactersDataToDomainMapper()
}
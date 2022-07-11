package com.stebakov.rickandmorty.di

import com.stebakov.homescreen.data.cloud.CharactersCloudMapper
import com.stebakov.homescreen.data.cloud.CharactersRepositoryImpl
import com.stebakov.homescreen.data.cloud.CharactersService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RemoteModule {

    @Provides
    fun provideCharactersService(retrofit: Retrofit): CharactersService {
        return retrofit.create(CharactersService::class.java)
    }

    @Provides
    fun provideCharactersRepositoryImpl(
        service: CharactersService,
        mapper: CharactersCloudMapper.Base
    ) = CharactersRepositoryImpl(service, mapper)

}
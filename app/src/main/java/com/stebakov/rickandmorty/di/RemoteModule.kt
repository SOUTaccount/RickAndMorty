package com.stebakov.rickandmorty.di

import com.stebakov.homescreen.data.network.CharactersRepositoryImpl
import com.stebakov.homescreen.data.network.CharactersService
import com.stebakov.homescreen.domain.repository.CharactersRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RemoteModule {

    @Provides
    fun provideCharactersService(retrofit: Retrofit): CharactersService {
        return retrofit.create(CharactersService::class.java)
    }

    @Provides
    fun provideCharactersRepositoryImpl(service: CharactersService) = CharactersRepositoryImpl(service)

}
package com.stebakov.rickandmorty.di

import com.stebakov.homescreen.data.network.CharactersService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RemoteModule {

    @Provides
    fun provideCharactersService(retrofit: Retrofit): CharactersService {
        return retrofit.create(CharactersService::class.java)
    }
}
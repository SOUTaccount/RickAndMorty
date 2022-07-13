package com.stebakov.homescreen.di

import com.stebakov.homescreen.data.cloud.service.CharactersService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class HomeScreenRemoteModule {

    @HomeScreenScope
    @Provides
    fun provideCharactersService(retrofit: Retrofit): CharactersService =
        retrofit.create(CharactersService::class.java)

}
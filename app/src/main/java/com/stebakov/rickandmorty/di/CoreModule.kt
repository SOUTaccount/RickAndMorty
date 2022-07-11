package com.stebakov.rickandmorty.di

import android.app.Application
import android.content.Context
import com.stebakov.core.ResourceProvider
import com.stebakov.homescreen.presentation.CharactersCommunication
import dagger.Module
import dagger.Provides

@Module
class CoreModule(private val application: Application) {

    @Provides
    fun provideContext(): Context = application

    @Provides
    fun provideCharactersCommunication() = CharactersCommunication.Base()

    @Provides
    fun provideResourceProvider(context: Context) = ResourceProvider.Base(context)
}
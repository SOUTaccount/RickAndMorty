package com.stebakov.core.di

import android.app.Application
import android.content.Context
import com.stebakov.core.ResourceProvider
import dagger.Module
import dagger.Provides


@Module
class CoreModule(private val application: Application) {

    @CoreScope
    @Provides
    fun provideContext(): Context = application


    @Provides
    fun provideResourceProvider(context: Context): ResourceProvider {
        return ResourceProvider.Base(context)
    }
}

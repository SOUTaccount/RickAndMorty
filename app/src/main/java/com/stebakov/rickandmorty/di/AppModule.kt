package com.stebakov.rickandmorty.di

import android.app.Application
import com.stebakov.rickandmorty.App
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

@AppScope
@Component(
    modules = [
        RemoteModule::class,
        NetworkModule::class
    ]
)

interface AppComponent {

    fun inject(app: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}

@Scope
annotation class AppScope

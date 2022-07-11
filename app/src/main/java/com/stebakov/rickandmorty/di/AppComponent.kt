package com.stebakov.rickandmorty.di

import android.app.Application
import com.stebakov.core.di.CoreComponent
import com.stebakov.homescreen.di.HomeScreenCoreModule
import com.stebakov.homescreen.di.HomeScreenModule
import com.stebakov.homescreen.di.HomeScreenRemoteModule
import com.stebakov.rickandmorty.App
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

@AppScope
@Component(
    modules = [
        HomeScreenModule::class,
        HomeScreenRemoteModule::class,
        HomeScreenCoreModule::class
    ], dependencies = [CoreComponent::class]
)

interface AppComponent {

    fun inject(app: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun core(coreComponent: CoreComponent): Builder
        fun build(): AppComponent
    }
}

@Scope
annotation class AppScope

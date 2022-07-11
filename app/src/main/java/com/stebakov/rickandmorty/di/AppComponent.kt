package com.stebakov.rickandmorty.di

import android.app.Application
import com.stebakov.homescreen.presentation.HomeScreenFragment
import com.stebakov.homescreen.presentation.HomeScreenViewModel
import com.stebakov.rickandmorty.App
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

@AppScope
@Component(
    modules = [
        CoreModule::class,
        RemoteModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        UseCaseModule::class,
        MapperModule::class
    ]
)

interface AppComponent {

    fun inject(homeScreenFragment: HomeScreenFragment)
    fun inject(app: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun core(coreModule: CoreModule): Builder
        fun build(): AppComponent
    }
}

@Scope
annotation class AppScope

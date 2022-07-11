package com.stebakov.rickandmorty

import android.app.Application
import com.stebakov.core.di.CoreComponent
import com.stebakov.core.di.CoreModule
import com.stebakov.core.di.CoreProvider
import com.stebakov.core.di.DaggerCoreComponent
import com.stebakov.homescreen.di.DaggerHomeScreenComponent
import com.stebakov.homescreen.di.HomeScreenComponent
import com.stebakov.homescreen.di.HomeScreenProvider
import com.stebakov.rickandmorty.di.AppComponent
import com.stebakov.rickandmorty.di.DaggerAppComponent

class App : Application(), CoreProvider, HomeScreenProvider {

    companion object {
        lateinit var appComponent: AppComponent
    }

    private lateinit var coreComponent: CoreComponent
    private lateinit var homeScreenComponent: HomeScreenComponent

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        coreComponent = DaggerCoreComponent.builder()
            .coreModule(CoreModule(this))
            .build()

        appComponent = DaggerAppComponent.builder()
            .application(this)
            .core(coreComponent)
            .build()

        homeScreenComponent = DaggerHomeScreenComponent.builder()
            .coreComponent(coreComponent)
            .build()
        appComponent.inject(this)
    }

    override fun provideCoreComponent(): CoreComponent = coreComponent

    override fun provideHomeScreenComponent(): HomeScreenComponent = homeScreenComponent
}
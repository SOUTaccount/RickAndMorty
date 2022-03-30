package com.stebakov.rickandmorty

import android.app.Application
import com.stebakov.homescreen.domain.usecases.GetCharactersUseCase
import com.stebakov.rickandmorty.di.AppComponent
import com.stebakov.rickandmorty.di.DaggerAppComponent
import javax.inject.Inject

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        appComponent.inject(this)
    }
}
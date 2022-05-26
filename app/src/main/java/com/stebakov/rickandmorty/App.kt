package com.stebakov.rickandmorty

import android.app.Application
import com.stebakov.core.di.AppComponent
import com.stebakov.core.di.DaggerAppComponent
import javax.inject.Inject

class App : Application() {

    companion object {
        lateinit var appComponent: com.stebakov.core.di.AppComponent
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
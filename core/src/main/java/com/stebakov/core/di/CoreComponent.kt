package com.stebakov.core.di

import android.content.Context
import com.stebakov.core.ResourceProvider
import dagger.Component
import retrofit2.Retrofit

@CoreScope
@Component(
    modules = [
        CoreModule::class,
        NetworkModule::class
    ]
)
interface CoreComponent {

    fun resourceProvider(): ResourceProvider
    fun context(): Context
    fun retrofit(): Retrofit

}
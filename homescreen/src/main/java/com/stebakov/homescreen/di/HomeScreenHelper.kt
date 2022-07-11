package com.stebakov.homescreen.di

import android.content.Context
import javax.inject.Scope

fun homeScreenComponent(context: Context) =
    (context.applicationContext as HomeScreenProvider).provideHomeScreenComponent()

interface HomeScreenProvider {
    fun provideHomeScreenComponent(): HomeScreenComponent
}

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class HomeScreenScope
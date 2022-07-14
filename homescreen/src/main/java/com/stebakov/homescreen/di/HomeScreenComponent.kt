package com.stebakov.homescreen.di

import com.stebakov.core.di.CoreComponent
import com.stebakov.homescreen.presentation.characters.HomeScreenFragment
import dagger.Component

@HomeScreenScope
@Component(
    modules = [
        HomeScreenModule::class,
        HomeScreenRemoteModule::class,
        HomeScreenCoreModule::class,
        HomeScreenMapperModule::class
    ], dependencies = [CoreComponent::class]
)
interface HomeScreenComponent {
    fun inject(homeScreenFragment: HomeScreenFragment)
}
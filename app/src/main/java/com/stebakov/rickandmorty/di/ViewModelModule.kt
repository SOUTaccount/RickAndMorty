package com.stebakov.rickandmorty.di

import com.stebakov.homescreen.domain.usecases.GetCharactersUseCase
import com.stebakov.homescreen.presentation.HomeScreenViewModel
import com.stebakov.homescreen.presentation.viewmodel.HomeScreenModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun provideHomeScreenViewModel(homeScreenModel: HomeScreenModel.Base) =
        HomeScreenViewModel(homeScreenModel = homeScreenModel)

    @Provides
    fun provideHomeScreenModel(getCharactersUseCase: GetCharactersUseCase) =
        HomeScreenModel.Base(getCharactersUseCase = getCharactersUseCase)
}
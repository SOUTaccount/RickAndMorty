package com.stebakov.homescreen.presentation

import com.stebakov.core.base.BaseViewModel
import com.stebakov.homescreen.presentation.viewmodel.HomeScreenModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeScreenViewModel @Inject constructor(private val homeScreenModel: HomeScreenModel) :
    BaseViewModel() {
    fun fetchCharacters() {
        CoroutineScope(Dispatchers.IO).launch {
            homeScreenModel.getCloudData()
        }
    }
}
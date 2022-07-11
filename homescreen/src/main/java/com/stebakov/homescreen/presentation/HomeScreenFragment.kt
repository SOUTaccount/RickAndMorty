package com.stebakov.homescreen.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stebakov.core.base.BaseFragment
import com.stebakov.homescreen.R
import javax.inject.Inject

class HomeScreenFragment : BaseFragment(R.layout.fragment_home_screen) {

    @Inject
    lateinit var homeScreenViewModel: HomeScreenViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeScreenViewModel.fetchCharacters()
    }

}
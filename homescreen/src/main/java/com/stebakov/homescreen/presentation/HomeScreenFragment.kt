package com.stebakov.homescreen.presentation

import android.os.Bundle
import android.view.View
import com.stebakov.core.base.BaseFragment
import com.stebakov.homescreen.R
import com.stebakov.homescreen.di.homeScreenComponent
import javax.inject.Inject

class HomeScreenFragment : BaseFragment(R.layout.fragment_home_screen) {

    @Inject
    lateinit var homeScreenViewModel: HomeScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        homeScreenComponent(requireContext()).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeScreenViewModel.fetchCharacters()
    }
}
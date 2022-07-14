package com.stebakov.homescreen.presentation.characters

import android.os.Bundle
import android.view.View
import com.stebakov.core.base.BaseFragment
import com.stebakov.core.utils.fragmentViewBinding
import com.stebakov.homescreen.R
import com.stebakov.homescreen.databinding.FragmentHomeScreenBinding
import com.stebakov.homescreen.di.homeScreenComponent
import javax.inject.Inject

class HomeScreenFragment : BaseFragment(R.layout.fragment_home_screen) {

    @Inject
    lateinit var homeScreenViewModel: HomeScreenViewModel

    private val binding by fragmentViewBinding { FragmentHomeScreenBinding.bind(it) }

    private val adapter = CharactersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        homeScreenComponent(requireContext()).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCharacters.adapter = adapter
        homeScreenViewModel.observe(this) {
            adapter.update(it)
        }
        homeScreenViewModel.fetchCharacters()
    }
}
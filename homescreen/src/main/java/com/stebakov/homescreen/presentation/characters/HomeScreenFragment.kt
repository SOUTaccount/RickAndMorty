package com.stebakov.homescreen.presentation.characters

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.stebakov.core.base.BaseFragment
import com.stebakov.core.utils.fragmentViewBinding
import com.stebakov.homescreen.R
import com.stebakov.homescreen.databinding.FragmentHomeScreenBinding
import com.stebakov.homescreen.di.homeScreenComponent
import com.stebakov.homescreen.presentation.TryAgain
import com.stebakov.homescreen.presentation.model.CharactersDetailsUi
import javax.inject.Inject

class HomeScreenFragment : BaseFragment(R.layout.fragment_home_screen) {

    @Inject
    lateinit var homeScreenViewModel: HomeScreenViewModel

    private val binding by fragmentViewBinding { FragmentHomeScreenBinding.bind(it) }

    private val adapter = CharactersAdapter(onLoadMoreItems = {
        binding.progressBar.visibility = View.VISIBLE
        homeScreenViewModel.fetchNextPage()
    },
        tryAgain = object : TryAgain {
            override fun retry() {
                homeScreenViewModel.fetchCharacters()
            }
        })

    override fun onCreate(savedInstanceState: Bundle?) {
        homeScreenComponent(requireContext()).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lm = GridLayoutManager(requireContext(), 2)
        binding.rvCharacters.layoutManager = lm
        binding.rvCharacters.adapter = adapter
        homeScreenViewModel.observe(this) {
            binding.progressBar.visibility = View.GONE
            lm.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return if (it[position] is CharactersDetailsUi.Progress || it[position] is CharactersDetailsUi.Fail)
                        2
                    else 1
                }
            }
            adapter.update(it)
        }
        homeScreenViewModel.fetchCharacters()
    }
}
package com.stebakov.rickandmorty.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.stebakov.core.utils.fragmentViewBinding
import com.stebakov.rickandmorty.R
import com.stebakov.rickandmorty.databinding.FragmentSplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private companion object {
        const val SPLASH_DURATION = 1800L
    }

    private val binding: FragmentSplashBinding by fragmentViewBinding {
        FragmentSplashBinding.bind(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this).load(R.drawable.rick).into(binding.ivSplash)
        CoroutineScope(Dispatchers.Main).launch {
            delay(SPLASH_DURATION)
            findNavController().navigate(R.id.action_splashFragment_to_MainFragment)
        }
    }
}
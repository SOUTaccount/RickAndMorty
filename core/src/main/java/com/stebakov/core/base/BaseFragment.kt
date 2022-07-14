package com.stebakov.core.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

open class BaseFragment(@LayoutRes var contentLayoutId: Int) : Fragment(contentLayoutId) {

    fun popBack() = requireActivity().onBackPressed()

}
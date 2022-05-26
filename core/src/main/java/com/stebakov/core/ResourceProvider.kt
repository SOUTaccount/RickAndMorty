package com.stebakov.core

import androidx.annotation.StringRes

interface ResourceProvider {
    fun getString(@StringRes id: Int): String
    fun getString(@StringRes id: Int, vararg args: Any): String

    //todo update resource provider (changed this on sls resource provider)
}
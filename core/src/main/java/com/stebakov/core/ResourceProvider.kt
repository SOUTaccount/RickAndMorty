package com.stebakov.core

import android.content.Context
import androidx.annotation.StringRes
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

interface ResourceProvider {
    fun getString(@StringRes id: Int): String
    fun getString(@StringRes id: Int, vararg args: Any): String

    @Singleton
    class Base @Inject constructor(@Named("AppContext") private val context: Context) :
        ResourceProvider {
        override fun getString(id: Int) = context.getString(id)

        override fun getString(id: Int, vararg args: Any) = context.getString(id, args)

    }
}
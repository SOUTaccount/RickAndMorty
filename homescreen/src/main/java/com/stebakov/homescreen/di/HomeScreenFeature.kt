package com.stebakov.homescreen.di

interface HomeScreenFeature {
    fun openHomeScreen()

    class Base() : HomeScreenFeature{
        override fun openHomeScreen() {

        }
    }
}
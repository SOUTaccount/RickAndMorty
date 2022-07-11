package com.stebakov.homescreen.presentation

sealed class CharactersDetailsUi {
    data class Base(
        private val id: Int,
        private val name: String,
        private val status: String,
        private val species: String,
        private val type: String,
        private val gender: String,
        private val image: String,
        private val episode: List<String>
    ) : CharactersDetailsUi()

    data class Fail(private val message: String) : CharactersDetailsUi()
    object Progress: CharactersDetailsUi()
}
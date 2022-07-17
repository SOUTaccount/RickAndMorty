package com.stebakov.homescreen.presentation.model

import com.stebakov.core.Comparing

sealed class CharactersDetailsUi : Comparing<CharactersDetailsUi> {
    data class Base(
        private val id: Int,
        private val name: String,
        private val status: String,
        private val species: String,
        private val type: String,
        private val gender: String,
        private val image: String,
        private val episode: List<String>
    ) : CharactersDetailsUi() {
        override fun same(item: CharactersDetailsUi) = item is Base && id == item.id
        override fun sameContent(item: CharactersDetailsUi) =
            if (item is Base) name == item.name else false

        fun name() = name
        fun status() = status
        fun species() = species
        fun gender() = gender
        fun image() = image
    }

    data class Fail(private val message: String) : CharactersDetailsUi() {
        override fun same(item: CharactersDetailsUi) = sameContent(item)

        override fun sameContent(item: CharactersDetailsUi) =
            if (item is Fail) message == item.message else false

        fun message() = message
    }

    object Progress : CharactersDetailsUi()
}
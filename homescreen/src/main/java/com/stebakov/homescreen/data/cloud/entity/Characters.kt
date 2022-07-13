package com.stebakov.homescreen.data.cloud.entity

import com.google.gson.annotations.SerializedName
import com.stebakov.core.Abstract
import com.stebakov.homescreen.data.model.CharactersDetailsData
import com.stebakov.homescreen.data.cloud.CharactersCloudMapper

data class Characters(
    @SerializedName("info")
    private val info: Info,
    @SerializedName("results")
    private val results: List<CharacterDetailsCloud>
) : Abstract.Object<List<CharactersDetailsData>, CharactersCloudMapper> {
    override fun map(mapper: CharactersCloudMapper) = mapper.map(results)
}
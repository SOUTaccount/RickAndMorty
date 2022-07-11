package com.stebakov.homescreen.data.cloud.entity

import com.google.gson.annotations.SerializedName
import com.stebakov.core.Abstract
import com.stebakov.homescreen.data.CharactersDetailsData
import com.stebakov.homescreen.data.ToCharactersDetailsMapper

data class CharacterDetailsCloud(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("name")
    private val name: String,
    @SerializedName("status")
    private val status: String,
    @SerializedName("species")
    private val species: String,
    @SerializedName("type")
    private val type: String,
    @SerializedName("gender")
    private val gender: String,
//    @SerializedName("origin")
//    val origin: Place,
//    @SerializedName("location")
//    val location: Place,
    @SerializedName("image")
    private val image: String,
    @SerializedName("episode")
    private val episode: List<String>
) : Abstract.Object<CharactersDetailsData, ToCharactersDetailsMapper> {
    override fun map(mapper: ToCharactersDetailsMapper) =
        mapper.map(id, name, status, species, type, gender, image, episode)
}
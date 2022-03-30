package com.stebakov.homescreen.data.entity

import com.google.gson.annotations.SerializedName

data class CharacterDetails(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("gender")
    val gender: String,
//    @SerializedName("origin")
//    val origin: Place,
//    @SerializedName("location")
//    val location: Place,
    @SerializedName("image")
    val image: String,
    @SerializedName("episode")
    val episode: List<String>
) {
//    fun toCharacterEntity() =
//        CharacterEntity(
//            id,
//            name,
//            status,
//            species,
//            type,
//            gender,
//            RegexUtil.extractIdFromUrl(origin.url),
//            RegexUtil.extractIdFromUrl(location.url),
//            image
//        )
}
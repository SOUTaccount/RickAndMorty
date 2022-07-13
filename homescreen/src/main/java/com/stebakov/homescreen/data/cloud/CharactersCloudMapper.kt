package com.stebakov.homescreen.data.cloud

import com.stebakov.core.Abstract
import com.stebakov.homescreen.data.model.CharactersDetailsData
import com.stebakov.homescreen.data.mappers.ToCharactersDetailsMapper
import com.stebakov.homescreen.data.cloud.entity.CharacterDetailsCloud
import javax.inject.Inject

interface CharactersCloudMapper :
    Abstract.Mapper.Data<List<CharacterDetailsCloud>, List<CharactersDetailsData>> {

    class Base @Inject constructor(private val charactersMapper: ToCharactersDetailsMapper) : CharactersCloudMapper {
        override fun map(data: List<CharacterDetailsCloud>) = data.map { characterDetailsCloud ->
            characterDetailsCloud.map(charactersMapper)
        }
    }
}
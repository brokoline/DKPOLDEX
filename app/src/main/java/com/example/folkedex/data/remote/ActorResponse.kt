package com.example.folkedex.data.remote

import com.example.folkedex.data.model.Actor
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ActorResponse(
    @SerialName("value") val actors: List<Actor>
)
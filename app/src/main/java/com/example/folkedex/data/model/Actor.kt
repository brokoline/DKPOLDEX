package com.example.folkedex.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Actor(
    val id: Int,
    val typeid: Int,
    val navn: String,
    val fornavn: String?,
    val efternavn: String?,
    val biografi: String?,
    @SerialName("opdateringsdato") val updatedDate: String,
    @SerialName("startdato") val startDate: String?,
    @SerialName("slutdato") val endDate: String?
)
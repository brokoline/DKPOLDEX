package com.example.folkedex.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FileResponse(
    @SerialName("value") val value: List<FileData>

)

@Serializable
data class FileData(
    val id: Int,
    val dokumenttid: Int? = null,
    val titel: String,
    val versionsdato: String? = null,
    @SerialName("filurl") val fileUrl: String,
    val opdateringsdato: String? = null,
    val variantkode: String? = null,
    val format: String? = null
)

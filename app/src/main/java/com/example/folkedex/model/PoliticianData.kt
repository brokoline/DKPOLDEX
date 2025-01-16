package com.example.folkedex.model

data class PoliticianData(
    val id: Int,
    val name: String,
    val photo: Int,
    val cardColor: Long,
    val partyName: String,
    val age: Int,
    val occupation: String,
    val email: String,
    val phone: Int
)
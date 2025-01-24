package com.example.folkedex.utilities

fun extractPartyFromBiography(biografi: String?): String? {
    if (biografi.isNullOrBlank()) return null

    val regex = "<party>(.*?)</party>".toRegex()
    val matchResult = regex.find(biografi)
    return matchResult?.groups?.get(1)?.value
}

fun extractPoliPictureFromBiography(biografi: String?): String? {
    if (biografi.isNullOrBlank()) return null

    val regex = "<pictureMiRes>(.*?)</pictureMiRes>".toRegex()
    val matchResult = regex.find(biografi)
    return matchResult?.groups?.get(1)?.value
}

fun extractPoliAgeFromBiography(biografi: String?): String? {
    if (biografi.isNullOrBlank()) return null

    val regex = "<born>(.*?)</born>".toRegex()
    val matchResult = regex.find(biografi)
    return matchResult?.groups?.get(1)?.value
}

fun extractPoliProfFromBiography(biografi: String?): String? {
    if (biografi.isNullOrBlank()) return null

    val regex = "<profession>(.*?)</profession>".toRegex()
    val matchResult = regex.find(biografi)
    return matchResult?.groups?.get(1)?.value
}

fun extractPoliEducationFromBiography(biografi: String?): String? {
    if (biografi.isNullOrBlank()) return null

    val regex = "<education>(.*?)</education>".toRegex()
    val matchResult = regex.find(biografi)
    return matchResult?.groups?.get(1)?.value
}

fun extractPoliMailFromBiography(biografi: String?): String? {
    if (biografi.isNullOrBlank()) return null

    val regex = "<email>(.*?)</email>".toRegex()
    val matchResult = regex.find(biografi)
    return matchResult?.groups?.get(1)?.value
}

fun extractPoliPhoneFromBiography(biografi: String?): String? {
    if (biografi.isNullOrBlank()) return null

    val regex = "<ministerPhone>(.*?)</ministerPhone>".toRegex()
    val matchResult = regex.find(biografi)
    return matchResult?.groups?.get(1)?.value
}

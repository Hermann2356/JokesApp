package com.hermannsterling.jokesapp.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Joke(
    val category: String,
    val type: String,
    val setup: String,
    val delivery: String,
    val flags: Flags,
    val id: Long,
    val safe: Boolean,
    val lang: String
) {

}

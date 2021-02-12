package com.hermannsterling.jokesapp.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize


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
    override fun toString(): String {
        return "Joke(category='$category', type='$type', setup='$setup', delivery='$delivery', flags=$flags, id=$id, safe=$safe, lang='$lang')"
    }
}

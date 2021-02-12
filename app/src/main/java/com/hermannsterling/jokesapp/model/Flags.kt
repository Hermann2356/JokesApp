package com.hermannsterling.jokesapp.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Flags(
    val nsfw: Boolean,
    val religious: Boolean,
    val political: Boolean,
    val racist: Boolean,
    val sexist: Boolean,
    val explicit: Boolean
) : Parcelable {
    override fun toString(): String {
        return "Flags(nsfw=$nsfw, religious=$religious, political=$political, racist=$racist, sexist=$sexist, explicit=$explicit)"
    }
}

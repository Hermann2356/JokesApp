package com.hermannsterling.jokesapp.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize



@JsonClass(generateAdapter = true)
data class JokeResponse(
    val error: Boolean,
    val amount: Int?,
    val jokes: List<Joke>
) {
    override fun toString(): String {
        return "JokeResponse(error=$error, amount=$amount, jokes=$jokes)"
    }
}

package com.mellagusty.movieapppopcorn.data

import android.os.Parcelable
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import kotlinx.android.parcel.Parcelize
import java.lang.reflect.Type

@Parcelize
data class Poster(
    val id : String,
    val release_date : String?,
    val first_air_date : String?,
    val poster_path : String,
    val original_title : String?,
    val original_name : String?,
): Parcelable {
    val baseUrl get() = "https://image.tmdb.org/t/p/w500"
}
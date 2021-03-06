package com.mellagusty.movieapppopcorn.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MoviePosterDetail(

    @field: SerializedName("id")
    val id: Int,

    @field: SerializedName("poster_path")
    val poster_path: String,

    @field: SerializedName("original_title")
    val original_title: String? = null,

    @field: SerializedName("overview")
    val overview: String? = null,

    @field: SerializedName("original_language")
    val original_language: String? = null,

    @field: SerializedName("genres")
    val genres: List<GenreModel>,

    @field: SerializedName("vote_average")
    val vote_average: Double? = null,

    @field: SerializedName("tagline")
    val tagline: String? = null,

    @field: SerializedName("status")
    val status: String? = null,

    @field: SerializedName("production_companies")
    val production_companies: List<ProductionCompany?>? = null

) : Parcelable{
    val baseUrl get() = "https://image.tmdb.org/t/p/w500"
}


@Parcelize
class ProductionCompany(
    @field: SerializedName("id")
    val id: Int,

    @field: SerializedName("name")
    val name: String? = null,

    @field: SerializedName("logo_path")
    val logoPath: String? = null,

    @field: SerializedName("origin_country")
    val origin_country: String? = null
) : Parcelable


@Parcelize
class GenreModel(
    @field: SerializedName("name")
    val name: String,

    @field: SerializedName("id")
    val id: Int
) : Parcelable

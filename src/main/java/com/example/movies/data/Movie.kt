package com.example.movies.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Movie(

    @SerializedName("poster_path")
    @Expose
    var posterPath: String?,

    @SerializedName("backdrop_path")
    @Expose
    var backdropPath: String?,

    @SerializedName("title")
    @Expose
    var title: String?,

    @SerializedName("overview")
    @Expose
    var overview: String?,

    @SerializedName("release_date")
    @Expose
    var releaseDate: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {

        parcel.writeString(posterPath)
        parcel.writeString(backdropPath)
        parcel.writeString(title)
        parcel.writeString(overview)
        parcel.writeString(releaseDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }


    }
}

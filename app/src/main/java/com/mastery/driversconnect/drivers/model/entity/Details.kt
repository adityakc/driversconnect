package com.mastery.driversconnect.drivers.model.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Details(
    @SerializedName("trailerWidth")
    val trailerWidth: Int = 0,
    @SerializedName("trailerHeight")
    val trailerHeight: Int = 0,
    @SerializedName("trailerLength")
    val trailerLength: Int = 0,
    @SerializedName("trailerType")
    val trailerType: String = "",
    @SerializedName("plateNumber")
    val plateNumber: String = "",
    @SerializedName("currentLocation")
    val currentLocation: CurrentLocation
) : Parcelable
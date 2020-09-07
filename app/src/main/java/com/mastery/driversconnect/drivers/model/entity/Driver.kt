package com.mastery.driversconnect.drivers.model.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Driver(@SerializedName("firstName")
                  val firstName: String = "",
                  @SerializedName("lastName")
                  val lastName: String = "",
                  @SerializedName("phoneNumber")
                  val phoneNumber: String = "",
                  @SerializedName("details")
                  val details: Details): Parcelable
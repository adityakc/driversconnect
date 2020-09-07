package com.mastery.driversconnect.drivers.model.entity

import com.google.gson.annotations.SerializedName

data class CurrentLocation(@SerializedName("latitude")
                           val latitude: String = "",
                           @SerializedName("longitude")
                           val longitude: String = "")
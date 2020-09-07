package com.mastery.driversconnect.drivers.model.entity

import com.google.gson.annotations.SerializedName

data class Driver(@SerializedName("firstName")
                  val firstName: String = "",
                  @SerializedName("lastName")
                  val lastName: String = "",
                  @SerializedName("phoneNumber")
                  val phoneNumber: String = "",
                  @SerializedName("details")
                  val details: Details)
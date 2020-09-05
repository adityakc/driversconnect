package com.mastery.driversconnect.login.model.entity

import com.google.gson.annotations.SerializedName

data class Credentials(
    @SerializedName("password")
    var password: String? = null,
    @SerializedName("username")
    var username: String? = null
)
package com.mastery.driversconnect.drivers.model.service

import com.mastery.driversconnect.login.model.entity.User
import io.reactivex.Flowable
import retrofit2.http.GET

interface DriversApi {

    @GET("/drivers")
    fun getDrivers(): Flowable<User>

}
package com.mastery.driversconnect.login.model.service

import com.mastery.driversconnect.login.model.entity.Credentials
import com.mastery.driversconnect.login.model.entity.User
import io.reactivex.Flowable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {

    @POST("/login")
    fun attemptLogin(@Body credentials: Credentials): Flowable<User>

}
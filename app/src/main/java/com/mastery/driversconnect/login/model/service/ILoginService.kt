package com.mastery.driversconnect.login.model.service

import com.mastery.driversconnect.login.model.entity.Credentials
import com.mastery.driversconnect.login.model.entity.User
import io.reactivex.Flowable

interface ILoginService {
    fun callLoginService(credentials: Credentials): Flowable<User>
}
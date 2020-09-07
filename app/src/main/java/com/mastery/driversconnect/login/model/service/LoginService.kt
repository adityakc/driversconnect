package com.mastery.driversconnect.login.model.service

import com.mastery.driversconnect.base.model.service.BaseService
import com.mastery.driversconnect.login.model.entity.Credentials
import com.mastery.driversconnect.login.model.entity.User
import io.reactivex.Flowable

class LoginService : BaseService(), ILoginService {

    override fun attemptLogin(credentials: Credentials): Flowable<User> {
        return createApiProxy(LoginApi::class.java).attemptLogin(credentials)
    }

}
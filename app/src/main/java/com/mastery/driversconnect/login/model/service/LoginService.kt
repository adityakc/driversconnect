package com.mastery.driversconnect.login.model.service

import com.mastery.driversconnect.base.model.service.BaseService

class LoginService: BaseService() {

    fun callLoginService(){
        createApiProxy(LoginApi::class.java)
    }

}
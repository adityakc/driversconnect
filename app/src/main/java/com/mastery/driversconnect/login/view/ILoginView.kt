package com.mastery.driversconnect.login.view

import com.mastery.driversconnect.base.view.IBaseView
import com.mastery.driversconnect.login.model.entity.User

interface ILoginView : IBaseView {
    fun onLoginSuccess(user: User)
    fun onLoginFailure()
}
package com.mastery.driversconnect.login.presenter

import com.mastery.driversconnect.base.presenter.BasePresenter
import com.mastery.driversconnect.login.model.entity.Credentials
import com.mastery.driversconnect.login.model.service.ILoginService
import com.mastery.driversconnect.login.view.ILoginView

class LoginPresenter(private val service: ILoginService) : BasePresenter<ILoginView>(),
    ILoginPresenter {

    override fun attemptLogin(userName: String?, password: String?) {
        if (!isValid(userName, password)) return
        val loginFlow = service.attemptLogin(Credentials(userName, password))
        subscribe(loginFlow, { user ->
            view?.onLoginSuccess(user)
        }, {

        })
    }

    override fun isValid(userName: String?, password: String?): Boolean {
        if (userName.isNullOrEmpty() || password.isNullOrEmpty()) {
            view?.onLoginFailure()
            return false
        }
        return true
    }
}
package com.mastery.driversconnect.login.presenter

import com.mastery.driversconnect.base.presenter.IBasePresenter
import com.mastery.driversconnect.login.view.ILoginView

interface ILoginPresenter: IBasePresenter<ILoginView> {
    fun attemptLogin(userName: String?, password: String?)
    fun isValid(userName: String?, password: String?): Boolean
}
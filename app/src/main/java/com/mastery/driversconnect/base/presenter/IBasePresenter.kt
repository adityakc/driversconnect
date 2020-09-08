package com.mastery.driversconnect.base.presenter

import com.mastery.driversconnect.base.view.IBaseView

interface IBasePresenter<View : IBaseView> {
    fun attachView(view: View)
    fun detachView()
}
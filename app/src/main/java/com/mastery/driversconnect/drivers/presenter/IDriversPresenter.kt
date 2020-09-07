package com.mastery.driversconnect.drivers.presenter

import com.mastery.driversconnect.base.presenter.IBasePresenter
import com.mastery.driversconnect.drivers.view.IDriversView

interface IDriversPresenter: IBasePresenter<IDriversView> {
    fun getDrivers()
}
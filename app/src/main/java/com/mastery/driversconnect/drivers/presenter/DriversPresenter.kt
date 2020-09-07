package com.mastery.driversconnect.drivers.presenter

import com.mastery.driversconnect.base.presenter.BasePresenter
import com.mastery.driversconnect.drivers.model.service.IDriversService
import com.mastery.driversconnect.drivers.view.IDriversView
import com.mastery.driversconnect.login.model.entity.Credentials
import com.mastery.driversconnect.login.model.service.ILoginService
import com.mastery.driversconnect.login.view.ILoginView

class DriversPresenter(private val service: IDriversService) : BasePresenter<IDriversView>(),
    IDriversPresenter {

    override fun getDrivers() {
        subscribe(service.getDrivers(), { drivers ->
            view?.onDriversFetched(drivers)
        }, {

        })
    }
}
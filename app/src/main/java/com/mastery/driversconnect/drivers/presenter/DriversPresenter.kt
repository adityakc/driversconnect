package com.mastery.driversconnect.drivers.presenter

import com.mastery.driversconnect.base.presenter.BasePresenter
import com.mastery.driversconnect.drivers.model.service.IDriversService
import com.mastery.driversconnect.drivers.view.IDriversView

class DriversPresenter(private val service: IDriversService) : BasePresenter<IDriversView>(),
    IDriversPresenter {

    override fun getDrivers() {
        subscribe(service.getDrivers(), { drivers ->
            view?.onDriversFetched(drivers)
        }, {

        })
    }
}
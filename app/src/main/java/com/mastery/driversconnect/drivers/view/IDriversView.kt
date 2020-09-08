package com.mastery.driversconnect.drivers.view

import com.mastery.driversconnect.base.view.IBaseView
import com.mastery.driversconnect.drivers.model.entity.Driver

interface IDriversView : IBaseView {
    fun onDriversFetched(drivers: List<Driver>)
}
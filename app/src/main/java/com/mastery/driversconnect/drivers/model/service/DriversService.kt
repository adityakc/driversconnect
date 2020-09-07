package com.mastery.driversconnect.drivers.model.service

import com.mastery.driversconnect.base.model.service.BaseService
import com.mastery.driversconnect.drivers.model.entity.Driver
import io.reactivex.Flowable

class DriversService : BaseService(), IDriversService {

    override fun getDrivers(): Flowable<List<Driver>> {
        return createApiProxy(DriversApi::class.java).getDrivers()
    }

}
package com.mastery.driversconnect.drivers.model.service

import com.mastery.driversconnect.drivers.model.entity.Driver
import io.reactivex.Flowable

interface IDriversService {
    fun getDrivers(): Flowable<List<Driver>>
}
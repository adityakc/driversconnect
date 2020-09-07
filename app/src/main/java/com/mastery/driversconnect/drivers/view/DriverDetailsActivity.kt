package com.mastery.driversconnect.drivers.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mastery.driversconnect.R
import com.mastery.driversconnect.constants.IntentKeys
import com.mastery.driversconnect.drivers.model.entity.Driver

class DriverDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_details)
        setUpUI()
    }


    private fun setUpUI(){
        val driver = intent.getParcelableExtra<Driver>(IntentKeys.KEY_DRIVER)
        setUpTitle(driver)

    }

    private fun setUpTitle(driver: Driver?) {
        title = "${driver?.firstName} ${driver?.lastName}, ${driver?.phoneNumber}"
    }


}
package com.mastery.driversconnect.drivers.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mastery.driversconnect.R
import com.mastery.driversconnect.constants.IntentKeys
import com.mastery.driversconnect.drivers.model.entity.Driver
import kotlinx.android.synthetic.main.activity_driver_details.*

class DriverDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_details)
        setUpUI()
    }


    private fun setUpUI() {
        val driver = intent.getParcelableExtra<Driver>(IntentKeys.KEY_DRIVER)
        setUpTitle(driver)
        setUpDetails(driver)


    }

    private fun setUpDetails(driver: Driver?) {
        driver?.details?.apply {
            text_view_trailer_type_data.text = trailerType
            text_view_trailer_dim_data.text = "$trailerLength X $trailerWidth X $trailerHeight"
            text_view_plate_number_data.text = plateNumber
        }
    }

    private fun setUpTitle(driver: Driver?) {
        title = "${driver?.firstName} ${driver?.lastName}, ${driver?.phoneNumber}"
    }


}
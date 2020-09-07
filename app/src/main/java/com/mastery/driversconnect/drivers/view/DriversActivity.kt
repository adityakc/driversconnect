package com.mastery.driversconnect.drivers.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
import com.mastery.driversconnect.R
import com.mastery.driversconnect.base.view.BaseActivity
import com.mastery.driversconnect.constants.StringConstants
import com.mastery.driversconnect.drivers.model.entity.Driver
import com.mastery.driversconnect.drivers.model.service.DriversService
import com.mastery.driversconnect.drivers.model.service.IDriversService
import com.mastery.driversconnect.drivers.presenter.DriversPresenter
import com.mastery.driversconnect.drivers.presenter.IDriversPresenter
import kotlinx.android.synthetic.main.activity_drivers.*

class DriversActivity : BaseActivity(), IDriversView {

    private lateinit var presenter: IDriversPresenter

    private var drivers: MutableList<Driver> = ArrayList()


    override fun setUpProgressBar() {
        progressBar = progress_bar_drivers_activity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drivers)
        setUpDependencies()
        setUpUI()
        setUpData()
    }

    private fun setUpDependencies() {
        val service: IDriversService = DriversService()
        presenter = DriversPresenter(service)
        presenter.attachView(this)
    }

    private val driversRecyclerViewAdapter = object : DriversRecyclerViewAdapter(drivers, R.layout.layout_driver) {

        override fun onDriverClick(driver: Driver) {
            TODO("Not yet implemented")
        }
    }

    private fun setUpUI() {
        setUpTitle()
        setUpRecyclerView()
    }

    private fun setUpTitle() {
        val fullName = intent.getStringExtra(StringConstants.KEY_FULL_NAME)
        title = "${getString(R.string.welcome)} $fullName"
    }

    private fun setUpRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        recycler_view_drivers.adapter = driversRecyclerViewAdapter
        recycler_view_drivers.layoutManager = layoutManager
        recycler_view_drivers.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun setUpData() {
        presenter.getDrivers()
    }


    override fun onDriversFetched(drivers: List<Driver>) {
        this.drivers.clear()
        this.drivers.addAll(drivers)
        recycler_view_drivers.adapter?.notifyDataSetChanged()

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
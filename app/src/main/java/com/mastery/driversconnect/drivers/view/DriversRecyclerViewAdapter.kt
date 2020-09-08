package com.mastery.driversconnect.drivers.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mastery.driversconnect.drivers.model.entity.Driver
import kotlinx.android.synthetic.main.layout_driver.view.*

abstract class DriversRecyclerViewAdapter(
    private val drivers: List<Driver>, private val layout: Int
) : RecyclerView.Adapter<DriversRecyclerViewAdapter.DriverViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverViewHolder {
        return DriverViewHolder(LayoutInflater.from(parent.context).inflate(layout, parent, false))
    }

    abstract fun onDriverClick(driver: Driver)

    override fun onBindViewHolder(holder: DriverViewHolder, position: Int) {
        val driver = drivers[position]
        holder.name.text = "${driver.firstName} ${driver.lastName}"
        holder.phone.text = driver.phoneNumber
        holder.mView.setOnClickListener {
            onDriverClick(driver)
        }
    }

    override fun getItemCount(): Int = drivers.size

    class DriverViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val name: TextView = mView.text_view_driver_name
        val phone: TextView = mView.text_view_driver_phone
    }

}
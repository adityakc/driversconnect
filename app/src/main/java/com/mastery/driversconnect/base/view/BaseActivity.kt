package com.mastery.driversconnect.base.view

import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mastery.driversconnect.R

/**
 * This is the base activity. All activities should inherit from base.
 */
abstract class BaseActivity : AppCompatActivity(), IBaseView {

    var progressBar: ProgressBar? = null

    abstract fun setUpProgressBar()

    override fun onDataFetchStarted() {
        progressBar?.visibility = View.VISIBLE
    }

    override fun onSuccess() {
        progressBar?.visibility = View.GONE
    }

    override fun onError(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_LONG).show()
        progressBar?.visibility = View.GONE
    }

    override fun onConnectionError() {
        Toast.makeText(this, getString(R.string.check_internet), Toast.LENGTH_LONG).show()
        progressBar?.visibility = View.GONE
    }
}

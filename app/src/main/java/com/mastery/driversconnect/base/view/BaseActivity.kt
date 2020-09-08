package com.mastery.driversconnect.base.view

import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

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
        progressBar?.visibility = View.GONE
    }

    override fun onConnectionError() {
        progressBar?.visibility = View.GONE
    }
}

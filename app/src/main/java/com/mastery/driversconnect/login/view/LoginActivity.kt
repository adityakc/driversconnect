package com.mastery.driversconnect.login.view

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.mastery.driversconnect.R
import com.mastery.driversconnect.base.view.BaseActivity
import com.mastery.driversconnect.drivers.view.DriversActivity
import com.mastery.driversconnect.login.model.entity.User
import com.mastery.driversconnect.login.model.service.ILoginService
import com.mastery.driversconnect.login.model.service.LoginService
import com.mastery.driversconnect.login.presenter.ILoginPresenter
import com.mastery.driversconnect.login.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Main User Login Activity and is Launcher Activity as well.
 */
class LoginActivity : BaseActivity(), ILoginView {

    lateinit var presenter: ILoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setUpDependencies()
        setUpUI()
    }

    private fun setUpUI() {
        setUpProgressBar()
        button_login.setOnClickListener {
            setUpData()
        }

    }

    override fun setUpProgressBar() {
        progressBar = progress_bar_login_activity
    }

    private fun setUpDependencies() {
        val loginService: ILoginService = LoginService()
        presenter = LoginPresenter(loginService)
        presenter.attachView(this)
    }

    private fun setUpData() {
        presenter.attemptLogin(
            edit_text_username?.text?.toString(),
            edit_text_password?.text?.toString()
        )
    }

    override fun onLoginFailure() {
        snackIt("Please complete the required fields")
    }

    private fun snackIt(message: String) {
        Snackbar.make(container, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun onLoginSuccess(user: User) {
        //go to Drivers List Activity
        val fullName = "${user.first} ${user.last}"
        val intent = Intent(this, DriversActivity::class.java)
        intent.putExtra("KEY_FULL_NAME", fullName)
        startActivity(intent)

    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }



}

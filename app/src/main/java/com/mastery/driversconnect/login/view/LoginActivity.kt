package com.mastery.driversconnect.login.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mastery.driversconnect.R
import com.mastery.driversconnect.base.view.BaseActivity

/**
 * Main User Login Activity and is Launcher Activity as well.
 */
class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

}

package com.mastery.driversconnect.login

import com.mastery.driversconnect.login.model.service.ILoginService
import com.mastery.driversconnect.login.presenter.LoginPresenter
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class LoginPresenterTest {

    private lateinit var presenter: LoginPresenter

    @Before
    fun setUp() {
        val service: ILoginService = mock { }
        presenter = LoginPresenter(service)
    }

    @Test
    fun checkIfFieldsAreNullOrEmptyTest_Login_Invalid_Empty_All() {
        val expected = false
        val actual = presenter.isValid("", "")
        assertEquals(expected, actual)
    }

    @Test
    fun checkIfFieldsAreNullOrEmptyTest_Login_Invalid_Null_Username() {
        val expected = false
        val actual = presenter.isValid(null, "a")
        assertEquals(expected, actual)
    }

    @Test
    fun checkIfFieldsAreNullOrEmptyTest_Login_Invalid_Null_Password() {
        val expected = false
        val actual = presenter.isValid("a", null)
        assertEquals(expected, actual)
    }

    @Test
    fun checkIfFieldsAreNullOrEmptyTest_Login_Invalid_Null_All() {
        val expected = false
        val actual = presenter.isValid(null, null)
        assertEquals(expected, actual)
    }

    @Test
    fun checkIfFieldsAreNullOrEmptyTest_Login_Valid() {
        val expected = true
        val actual = presenter.isValid("a", "b")
        assertEquals(expected, actual)
    }
}
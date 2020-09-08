package com.mastery.driversconnect

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Need to setup Instrumentation Testing
 *
 */
@RunWith(AndroidJUnit4::class)
class LoginPresenterTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.mastery.driversconnect", appContext.packageName)
    }
}
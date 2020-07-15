package com.iteo.androidcleanuitests

import android.app.Activity
import androidx.test.core.app.ActivityScenario
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.After
import org.junit.Before

abstract class KaspressoLifecycleTest<T : Activity?>(private val kClass: Class<T>): TestCase() {

    protected lateinit var activityScenario: ActivityScenario<T>

    abstract fun onSetup()

    @Before
    fun setup() {
        activityScenario = ActivityScenario.launch(kClass)
        onSetup()
    }

    @After
    fun close() {
        activityScenario.close()
    }
}
package com.iteo.androidcleanuitests

import android.app.Activity
import androidx.test.core.app.ActivityScenario
import org.junit.After
import org.junit.Before

abstract class LifecycleTest<T : Activity?>(private val kClass: Class<T>) {

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
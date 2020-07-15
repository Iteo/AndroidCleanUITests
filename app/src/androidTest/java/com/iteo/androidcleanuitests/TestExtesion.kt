package com.iteo.androidcleanuitests

import android.app.Activity
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario

fun ActivityScenario<out Activity>.onStop() {
    // It is said in documentation that is state after onStop()
    moveToState(Lifecycle.State.CREATED)
    // Test case will be waiting for RESUME state
    moveToState(Lifecycle.State.RESUMED)
}
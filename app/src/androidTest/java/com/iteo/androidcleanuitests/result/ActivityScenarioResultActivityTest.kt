package com.iteo.androidcleanuitests.result

import android.app.Activity
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import com.iteo.androidcleanuitests.ResultActivity
import org.junit.Before
import org.junit.Test

class ActivityScenarioResultActivityTest {
    private lateinit var activityScenario: ActivityScenario<ResultActivity>

    @Before
    fun setup() {
        // Default state is RESUMED
        activityScenario = launchActivity()
    }

    @Test
    fun activity_should_terminate_with_result() {
        with(activityScenario) {
            assert(result.resultCode == Activity.RESULT_OK)
            assert(state == Lifecycle.State.DESTROYED)
        }
    }
}
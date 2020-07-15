package com.iteo.androidcleanuitests.singlechange

import androidx.core.view.isVisible
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.iteo.androidcleanuitests.R
import com.iteo.androidcleanuitests.SingleChangeActivity
import com.iteo.androidcleanuitests.onStop
import kotlinx.android.synthetic.main.activity_single_change.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActivityScenarioSingleChangeActivityTest {

    private lateinit var activity: ActivityScenario<SingleChangeActivity>

    @Before
    fun setup() {
        // Default state is RESUMED
        activity = launchActivity()

        // Check some preconditions when activity is created
        activity.onActivity {
            assert(!it.logoView.isVisible)
            assert(it.button.isVisible)
            assert(it.textView.isVisible)
        }
    }

    @Test
    fun show_saved_text_when_activity_is_recreated() {
        // SAVE_INSTANCE -> DESTROYED -> RESUMED
        activity.recreate()

        onView(withId(R.id.textView))
            .check(matches(withText("State saved")))
    }

    @Test
    fun show_alert_when_user_stopped_app() {
        activity.onStop()

        onView(withId(R.id.logoView)).check(matches(isDisplayed()))
    }

    @After
    fun release() {
        activity.close()
    }
}
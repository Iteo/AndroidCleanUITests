package com.iteo.androidcleanuitests.singlechange

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.iteo.androidcleanuitests.R
import com.iteo.androidcleanuitests.SingleChangeActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EspressoMainActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(SingleChangeActivity::class.java)

    @Test
    fun center_field_should_change_text_after_click() {
        Espresso.onView(ViewMatchers.withId(R.id.button))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.textView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Clicked")))
    }
}
package com.iteo.androidcleanuitests.manysteps

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.iteo.androidcleanuitests.KaspressoLifecycleTest
import com.iteo.androidcleanuitests.ManyStepsActivity
import com.iteo.androidcleanuitests.screen.ManyStepsScreen
import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KaspressoManyStepsActivityTest :
    KaspressoLifecycleTest<ManyStepsActivity>(ManyStepsActivity::class.java) {

    override fun onSetup() {}

    @Test
    fun on_first_button_click_should_show_second_button() {
        run {
            // Run as Kaspresso test
            ManyStepsScreen {
                // Kakao syntax
                // Just describe in steps manner
                step("Click first button") { firstButton { click() } }
                step("Check if second button visible") {
                    firstButton { isVisible() }
                }
            }
        }
    }

    @Test
    fun on_both_buttons_click_should_show_all_buttons() {
        ManyStepsScreen {
            before {
                // Prepare test case
            }.after {
                // Do something on end of the test
            }.run {
                step("Click first button") { firstButton.click() }
                step("Click second button") { secondButton.click() }
                step("Check if all buttons are visible") {
                    CheckAllButtonsAreVisible()
                }
            }
        }
    }
}

class CheckAllButtonsAreVisible : Scenario() {
    override val steps: TestContext<Unit>.() -> Unit
        get() = {
            ManyStepsScreen {
                firstButton.isVisible()
                secondButton.isVisible()
                thirdButton.isVisible()
            }
        }
}
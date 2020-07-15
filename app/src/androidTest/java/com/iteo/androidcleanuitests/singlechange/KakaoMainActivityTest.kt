package com.iteo.androidcleanuitests.singlechange

import android.util.Log
import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.agoda.kakao.Kakao
import com.agoda.kakao.screen.Screen.Companion.onScreen
import com.iteo.androidcleanuitests.SingleChangeActivity
import com.iteo.androidcleanuitests.screen.HomeScreen
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KakaoMainActivityTest {

    @Before
    fun setup() {
        launchActivity<SingleChangeActivity>()
        Kakao {
            invoke {
                // Do something on runtime
            }

            intercept {
                onViewInteraction {
                    onPerform { interaction, action ->
                        Log.d("KAKAO", "$interaction is performing $action")
                    }
                }
            }

            reset() // Reset all interceptors
        }
    }

    @Test
    fun center_field_should_change_text_after_click() {
        onScreen<HomeScreen> {
            button {
                click()
            }
            field {
                hasText("Clicked")
            }
        }
    }
}
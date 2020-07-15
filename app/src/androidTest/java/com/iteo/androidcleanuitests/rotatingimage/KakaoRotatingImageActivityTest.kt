package com.iteo.androidcleanuitests.rotatingimage

import com.agoda.kakao.screen.Screen.Companion.onScreen
import com.iteo.androidcleanuitests.LifecycleTest
import com.iteo.androidcleanuitests.screen.RotatingImageScreen
import org.junit.Test

class KakaoRotatingImageActivityTest :
    LifecycleTest<RotatingImageActivity>(RotatingImageActivity::class.java) {

    override fun onSetup() {}

    @Test
    fun view_should_rotate_90_degrees_after_click() {
        onScreen<RotatingImageScreen> {
            image {
                click()
                isRotated(90)
            }
        }
    }
}
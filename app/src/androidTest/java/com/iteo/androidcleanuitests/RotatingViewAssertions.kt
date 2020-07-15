package com.iteo.androidcleanuitests

import android.view.View
import androidx.test.espresso.assertion.ViewAssertions
import com.agoda.kakao.common.assertions.BaseAssertions
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

// BaseAssertions has not method for checking rotation
interface RotatingViewAssertions : BaseAssertions {
    fun isRotated(angle: Int) {
        view.check(
            ViewAssertions.matches(
                RotationMatcher(angle.toFloat())
            )
        )
    }
}

// There isn't also rotation matcher indeed
class RotationMatcher(private val rotation: Float) : TypeSafeMatcher<View>() {

    override fun describeTo(description: Description?) {
        description?.appendText("is rotated by $rotation angle")
    }

    override fun matchesSafely(item: View?): Boolean = item?.rotation == rotation
}
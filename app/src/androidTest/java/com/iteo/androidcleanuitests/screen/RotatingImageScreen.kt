package com.iteo.androidcleanuitests.screen

import android.view.View
import androidx.test.espresso.DataInteraction
import com.agoda.kakao.common.actions.BaseActions
import com.agoda.kakao.common.builders.ViewBuilder
import com.agoda.kakao.common.views.KBaseView
import com.agoda.kakao.screen.Screen
import com.iteo.androidcleanuitests.R
import com.iteo.androidcleanuitests.RotatingViewAssertions
import org.hamcrest.Matcher

class KRotatingImageView :
    KBaseView<KRotatingImageView>, // This must be implemented
    BaseActions, // You can find many useful already defined actions like. DatePickerAction
    RotatingViewAssertions // You can also write custom assertion
{
    // Add all possible constructors
    constructor(function: ViewBuilder.() -> Unit) : super(function)
    constructor(parent: Matcher<View>, function: ViewBuilder.() -> Unit) : super(parent, function)
    constructor(parent: DataInteraction, function: ViewBuilder.() -> Unit) : super(parent, function)
}

class RotatingImageScreen : Screen<RotatingImageScreen>() {
    // Now you can just simply use as any other KView
    val image = KRotatingImageView { withId(R.id.rotatingImage) }
}
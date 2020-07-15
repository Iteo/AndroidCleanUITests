package com.iteo.androidcleanuitests.screen

import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.iteo.androidcleanuitests.R

object ManyStepsScreen : Screen<ManyStepsScreen>() {
    val firstButton = KButton { withId(R.id.actionShowSecond) }
    val secondButton = KButton { withId(R.id.actionShowThird) }
    val thirdButton = KButton { withId(R.id.actionHideAll) }
}
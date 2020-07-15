package com.iteo.androidcleanuitests.screen

import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.iteo.androidcleanuitests.R

class HomeScreen : Screen<HomeScreen>() {
    val button = KButton { withId(R.id.button) }
    val field = KTextView { withId(R.id.textView) }
}
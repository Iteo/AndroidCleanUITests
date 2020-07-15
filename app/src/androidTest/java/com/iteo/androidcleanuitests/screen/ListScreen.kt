package com.iteo.androidcleanuitests.screen

import android.view.View
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import com.iteo.androidcleanuitests.R
import org.hamcrest.Matcher

class ListScreen : Screen<ListScreen>() {

    val recycler = KRecyclerView(
        builder = { withId(R.id.list) },
        itemTypeBuilder = { itemType(ListScreen::Item) }
    )

    internal class Item(parent: Matcher<View>) : KRecyclerItem<Item>(parent) {
        val title: KTextView = KTextView(parent) { withId(R.id.viewItemText) }
    }
}
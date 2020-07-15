package com.iteo.androidcleanuitests.list

import com.agoda.kakao.screen.Screen.Companion.onScreen
import com.iteo.androidcleanuitests.LifecycleTest
import com.iteo.androidcleanuitests.screen.ListScreen
import org.junit.Test

private const val LIST_SIZE = 20

class KakaoListActivityTest : LifecycleTest<ListActivity>(ListActivity::class.java) {

    override fun onSetup() {}

    @Test
    fun on_start_list_has_20_items() {
        onScreen<ListScreen> {
            recycler {
                hasSize(LIST_SIZE)
            }
        }
    }

    @Test
    fun list_item_has_proper_title() {
        onScreen<ListScreen> {
            recycler {
                firstChild<ListScreen.Item> {
                    // Be aware of ViewGroup and it's descendant
                    isVisible()
                    title { hasText("Element 0") }
                }
            }
        }
    }

    @Test
    fun after_click_on_item_it_disappear() {
        onScreen<ListScreen> {
            recycler {
                firstChild<ListScreen.Item> {
                    click()
                }
                assert(getSize() == LIST_SIZE - 1)
            }
        }
    }
}
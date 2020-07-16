# AndroidCleanUITests

This repository shows basic UI tests with usage of ActivityScenario, Kakao and Kaspresso. 
Thanks to these libraries code for the tests can be clean and readable in contrast to Espresso.

## Single change

First example is utterly basic, but it is an introduction into Kakao syntax.

<img alt="Button with action which changes text field" src="/single.gif" width="300" />

```kotlin
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
```

## RecyclerView

With Kaspresso testing Android's lists is also painless.

<img alt="List with item being removed" src="/list.gif" width="300" />

```kotlin
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
```

## Custom View

In the code was created RotatingImageView.  
This class with some work done may be very easily tested.

<img alt="Image with rotation after click" src="/rotating.gif" width="300" />

```kotlin
@Test
fun view_should_rotate_90_degrees_after_click() {
    onScreen<RotatingImageScreen> {
        image {
            click()
            isRotated(90)
        }
    }
}
```

## Many steps

Sometimes test may require to invoke many actions before obtaining final result.  
This can be accomplished with Kaspresso's step function.

<img alt="Sequence of buttons clicks" src="/many.gif" width="300" />

```kotlin
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
```

## Activity with Result

ActivityScenario simplifies opening activities with given lifecycle.  
It can also verify returned result from screen.

<img alt="Sequence of buttons clicks" src="/result.gif" width="300" />

```kotlin
@Test
fun activity_should_terminate_with_result() {
    with(activityScenario) {
        assert(result.resultCode == Activity.RESULT_OK)
        assert(state == Lifecycle.State.DESTROYED)
    }
}
```

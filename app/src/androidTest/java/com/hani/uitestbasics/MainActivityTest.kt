package com.hani.uitestbasics

import android.text.style.ClickableSpan
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.codingwithmitch.espressouitestexamples.ui.main.MainActivity
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {


    @Test
    fun view_isDisplay_true() {
        val mainActivityScenario = ActivityScenario.launch(MainActivity::class.java)
        Espresso.onView(ViewMatchers.withId(R.id.main))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


    @Test
    fun nextButton_isDisplay_true() {
        val mainActivityScenario = ActivityScenario.launch(MainActivity::class.java)

        //Option 1
        Espresso.onView(ViewMatchers.withId(R.id.button_next_activity))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        //Option 2
        Espresso.onView(ViewMatchers.withId(R.id.button_next_activity)).check(
            ViewAssertions.matches(
                ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)
            )
        )

    }

    @Test
    fun title_isDisplay_true() {
        val mainActivityScenario = ActivityScenario.launch(MainActivity::class.java)

        Espresso.onView(ViewMatchers.withId(R.id.activity_main_title)).check(
            ViewAssertions.matches(
                ViewMatchers.withText(R.string.text_mainactivity)
            )
        )
    }


    @Test
    fun navigation_toSecondaryScreen_true() {
        val mainActivityScenario = ActivityScenario.launch(MainActivity::class.java)

        Espresso.onView(ViewMatchers.withId(R.id.button_next_activity)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withText(R.string.text_secondaryactivity)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )

    }

    @Test
    fun navigation_toSecondaryScreenAndBack_true() {
        val mainActivityScenario = ActivityScenario.launch(MainActivity::class.java)

        Espresso.onView(ViewMatchers.withId(R.id.button_next_activity)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withText(R.string.text_secondaryactivity)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )

        Espresso.pressBack()


        Espresso.onView(ViewMatchers.withText(R.string.text_mainactivity)).check(
            ViewAssertions.matches(
                ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)
            )
        )


    }
}
package com.hani.uitestbasics


import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.hani.uitestbasics.main.ui.SecondaryActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondaryActivityTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(SecondaryActivity::class.java)


    @Test
    fun view_isDisplay_true() {
        Espresso.onView(ViewMatchers.withId(R.id.secondary)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }


    @Test
    fun backButton_isDisplay_true() {
        Espresso.onView(ViewMatchers.withId(R.id.button_back)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }

    @Test
    fun title_isDisplay_true() {
        Espresso.onView(ViewMatchers.withId(R.id.activity_secondary_title)).check(
            ViewAssertions.matches(
                ViewMatchers.withText(R.string.text_secondaryactivity)
            )
        )
    }
}
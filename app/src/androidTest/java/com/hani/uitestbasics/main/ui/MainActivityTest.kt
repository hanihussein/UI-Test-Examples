package com.hani.uitestbasics.main.ui

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.hani.uitestbasics.R
import kotlinx.android.synthetic.main.activity_main.view.*
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {


    @get:Rule
    val activityScenario = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun `test_dialog_visibility`() {

        Espresso.onView(ViewMatchers.withId(R.id.button_launch_dialog)).perform(ViewActions.click())

        Espresso.onView(
            ViewMatchers.withText(
                R.string.text_enter_name
            )
        ).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


        Espresso.onView(
            ViewMatchers.withText(
                R.string.text_ok
            )
        ).perform(ViewActions.click())


        Espresso.onView(
            ViewMatchers.withText(
                R.string.text_enter_name
            )
        ).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


    }


    @Test
    fun `test_TextName_setCorrect`() {

        val EXCEPECTED_NAME = "HANI HUSSEIN"

        Espresso.onView(ViewMatchers.withId(R.id.button_launch_dialog)).perform(ViewActions.click())

        Espresso.onView(
            ViewMatchers.withId(
                R.id.md_input_message
            )
        ).perform(ViewActions.typeText(EXCEPECTED_NAME))


        Espresso.onView(
            ViewMatchers.withText(
                R.string.text_ok
            )
        ).perform(ViewActions.click())


        Espresso.onView(
            ViewMatchers.withId(
                R.id.text_name
            )
        ).check(ViewAssertions.matches(ViewMatchers.withText(EXCEPECTED_NAME)))

    }
}
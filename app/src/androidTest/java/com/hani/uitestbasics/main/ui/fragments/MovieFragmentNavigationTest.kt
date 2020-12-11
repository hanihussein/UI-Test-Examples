package com.hani.uitestbasics.main.ui.fragments

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.hani.uitestbasics.R
import com.hani.uitestbasics.main.ui.MainActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MovieFragmentNavigationTest {

    @Test
    fun movieFragment_navigation_isCorrect() {


        //SETUP
        val scenarioActivity = ActivityScenario.launch(MainActivity::class.java)

        //Nav Directors Fragment
        Espresso.onView(ViewMatchers.withId(R.id.movie_directiors)).perform(ViewActions.click())

        //VERIFY
        Espresso.onView(ViewMatchers.withId(R.id.fragment_movie_directiors_parent)).check(
            ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.pressBack()

        //VERIFY
        Espresso.onView(ViewMatchers.withId(R.id.fragment_movie_details_parent)).check(
            ViewAssertions.matches(ViewMatchers.isDisplayed()))

        //Nav Actors Fragment
        Espresso.onView(ViewMatchers.withId(R.id.movie_star_actors)).perform(ViewActions.click())


        //VERIFY
        Espresso.onView(ViewMatchers.withId(R.id.fragment_movie_actors_parent)).check(
            ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }
}
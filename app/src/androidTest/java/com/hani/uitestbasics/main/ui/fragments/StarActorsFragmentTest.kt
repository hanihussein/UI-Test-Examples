package com.hani.uitestbasics.main.ui.fragments

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.hani.uitestbasics.R
import com.hani.uitestbasics.data.DummyMovies
import com.hani.uitestbasics.main.ui.factory.MovieFragmentFactory
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class StarActorsFragmentTest {


    @Test
    fun statActorsData_isDisplayed_true() {

        val movie = DummyMovies.THE_RUNDOWN

        val bundle = Bundle()
        bundle.putStringArrayList("args_actors", movie.star_actors)

        val factory = MovieFragmentFactory()

        val fragmentScenario =
            launchFragmentInContainer<StarActorsFragment>(bundle, factory = factory)

        Espresso.onView(ViewMatchers.withId(R.id.star_actors_text)).check(
            ViewAssertions.matches(
                ViewMatchers.withText(StarActorsFragment.stringBuilderForStarActors(movie.star_actors!!))
            )
        )

    }
}
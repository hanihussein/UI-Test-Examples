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
import kotlinx.android.synthetic.main.fragment_directors.view.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DirectorsFragmentTest {


    @Test
    fun directorsData_isDisplayed_true() {

        val movie = DummyMovies.THE_RUNDOWN

        val bundle = Bundle()
        bundle.putStringArrayList("args_directors", movie.directors)

        val factory = MovieFragmentFactory()

        val fragmentScenario =
            launchFragmentInContainer<DirectorsFragment>(bundle, factory = factory)

        Espresso.onView(ViewMatchers.withId(R.id.directors_text)).check(
            ViewAssertions.matches(
                ViewMatchers.withText(DirectorsFragment.stringBuilderForDirectors(movie.directors!!))
            )
        )

    }
}
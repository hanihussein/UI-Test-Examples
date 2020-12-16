package com.hani.uitestbasics.main.ui

import android.os.Bundle
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.bumptech.glide.request.RequestOptions
import com.codingwithmitch.espressouitestexamples.data.Movie
import com.codingwithmitch.espressouitestexamples.data.source.MoviesRemoteDataSource
import com.codingwithmitch.espressouitestexamples.factory.MovieFragmentFactory
import com.hani.uitestbasics.R
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MovieDetailFragmentTest {

    @Test
    fun `test_isMovieDetailsVisiable`() {


        val movieId = 1
        val movieTitle = "The Rundown"
        val movieImageUrl =
            "https://nyc3.digitaloceanspaces.com/open-api-spaces/open-api-static/blog/1/The_Rundown-the_rundown.png"
        val movieDesc =
            "A tough aspiring chef is hired to bring home a mobster's son from the Amazon but " +
                    "becomes involved in the fight against an oppressive town operator and the search " +
                    "for a legendary treasure."

        val movie = Movie(
            movieId, movieTitle, movieImageUrl, movieDesc,
            arrayListOf("R.J. Stewart", "James Vanderbilt"),
            arrayListOf(
                "Dwayne Johnson",
                "Seann William Scott",
                "Rosario Dawson",
                "Christopher Walken"
            )
        )

        val remoteDataSource = mockk<MoviesRemoteDataSource>()
        every {
            remoteDataSource.getMovie(movieId)
        } returns movie

        val requestOption = RequestOptions
            .placeholderOf(R.drawable.default_image)
            .error(R.drawable.default_image)

        val fragmentFactory = MovieFragmentFactory(requestOption, remoteDataSource)

        val bundle = Bundle()
        bundle.putInt("movie_id", movieId)

        val fragmentScenario =  launchFragmentInContainer<MovieDetailFragment>(bundle , factory = fragmentFactory)

        onView(ViewMatchers.withId(R.id.movie_title)).check(ViewAssertions.matches(ViewMatchers.withText(movieTitle)))
        onView(ViewMatchers.withId(R.id.movie_description)).check(ViewAssertions.matches(ViewMatchers.withText(movieDesc)))

    }
}
package com.hani.uitestbasics.data.source

import com.hani.uitestbasics.data.Movie

interface MoviesDataSource {

    fun getMovie(movieId: Int): Movie?
}
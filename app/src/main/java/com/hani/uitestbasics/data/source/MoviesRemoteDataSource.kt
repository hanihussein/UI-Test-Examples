package com.hani.uitestbasics.data.source

import com.hani.uitestbasics.data.Movie
import com.hani.uitestbasics.data.DummyMovies

object MoviesRemoteDataSource: MoviesDataSource {

    private var MOVIES_REMOTE_DATA = LinkedHashMap<Int, Movie>(2)

    init {
        addMovie(DummyMovies.INFINITY_WAR)
        addMovie(DummyMovies.THE_RUNDOWN)
    }

    override fun getMovie(movieId: Int): Movie? {
        return MOVIES_REMOTE_DATA[movieId]
    }

    private fun addMovie(movie: Movie){
        MOVIES_REMOTE_DATA.put(movie.id, movie)
    }


}















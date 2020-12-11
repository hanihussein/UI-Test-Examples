package com.hani.uitestbasics.main.ui.factory

import androidx.fragment.app.FragmentFactory
import com.hani.uitestbasics.main.ui.fragments.DirectorsFragment
import com.hani.uitestbasics.main.ui.fragments.MovieDetailFragment
import com.hani.uitestbasics.main.ui.fragments.StarActorsFragment

class MovieFragmentFactory : FragmentFactory(){

    private val TAG: String = "AppDebug"

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when(className){

            MovieDetailFragment::class.java.name -> {
                MovieDetailFragment()
            }

            DirectorsFragment::class.java.name -> {
                DirectorsFragment()
            }

            StarActorsFragment::class.java.name -> {
                StarActorsFragment()
            }

            else -> {
                super.instantiate(classLoader, className)
            }
        }


}














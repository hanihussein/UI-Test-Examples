package com.hani.uitestbasics.main.ui.fragments

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MovieDetailFragmentTest::class, DirectorsFragmentTest::class,
    StarActorsFragmentTest::class,
    MovieFragmentNavigationTest::class
)
class MovieFragmentTestSuits
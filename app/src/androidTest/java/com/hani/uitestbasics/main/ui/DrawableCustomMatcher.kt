package com.hani.uitestbasics.main.ui

import android.view.View
import android.widget.ImageView
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher

object DrawableCustomMatcher {

    fun hasDrawable(): BoundedMatcher<View, ImageView> {

        return object : BoundedMatcher<View, ImageView>(ImageView::class.java) {

            override fun describeTo(description: Description?) {
                description?.appendText("hasDrawable")
            }

            override fun matchesSafely(item: ImageView?): Boolean {
                return item?.drawable != null
            }
        }

    }
}
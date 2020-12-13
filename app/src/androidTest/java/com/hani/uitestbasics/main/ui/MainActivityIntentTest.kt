package com.hani.uitestbasics.main.ui

import android.app.Activity
import android.app.Instrumentation
import android.content.ContentResolver
import android.content.res.Resources
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.hani.uitestbasics.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityIntentTest {

    @get:Rule
    val intentsTestRule = IntentsTestRule(MainActivity::class.java)


    @Test
    fun cameraIntent_Validate_true() {

        // Requested Intent
        val expectedIntent: Matcher<Intent> = hasAction(MediaStore.ACTION_IMAGE_CAPTURE)

        //ExpectedResult
        val activityResult = getCameraPickActivityResultStub()
        intending(expectedIntent).respondWith(activityResult)


        Espresso.onView(withId(R.id.image)).check(
            ViewAssertions.matches(
                Matchers.not(
                    DrawableCustomMatcher.hasDrawable()
                )
            )
        )

        //Act
        Espresso.onView(withId(R.id.button_camera)).perform(ViewActions.click())

        // Assert
        intended(expectedIntent)

        Espresso.onView(withId(R.id.image)).check(
            ViewAssertions.matches(
                DrawableCustomMatcher.hasDrawable()
            )
        )

    }


    private fun getCameraPickActivityResultStub(): Instrumentation.ActivityResult {

        val resources: Resources = InstrumentationRegistry.getInstrumentation().context.resources
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_launcher_background)

        val bundle = Bundle()
        bundle.putParcelable(KEY_IMAGE_DATA, bitmap)

        val intentResult = Intent()
        intentResult.putExtras(bundle)

        return Instrumentation.ActivityResult(Activity.RESULT_OK, intentResult)

    }
}
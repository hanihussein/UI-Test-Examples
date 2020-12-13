package com.hani.uitestbasics.main.ui

import android.app.Activity
import android.app.Instrumentation
import android.content.ContentResolver
import android.content.res.Resources
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
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
    fun galleryIntent_Validate_true() {

        // Requested Intent
        val expectedIntent: Matcher<Intent> = Matchers.allOf(hasAction(Intent.ACTION_PICK), hasData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI))

        //ExpectedResult
        val activityResult = getGalleryPickActivityResultStub()
        intending(expectedIntent).respondWith(activityResult)

        //Act
        Espresso.onView(ViewMatchers.withId(R.id.button_open_gallery)).perform(ViewActions.click())

        // Assert
        intended(expectedIntent)

    }


    private fun getGalleryPickActivityResultStub(): Instrumentation.ActivityResult {

        val resources:Resources = InstrumentationRegistry.getInstrumentation().context.resources


//        val imageUri = ( Uri.Builder())
//                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
//                .authority(resources.getResourcePackageName(R.drawable.ic_launcher_background))
//                .appendPath(resources.getResourceTypeName(R.drawable.ic_launcher_background))
//                .appendPath(resources.getResourceEntryName(R.drawable.ic_launcher_background))
//                .build()

        val imageUri = Uri.parse("android.resource://com.hani.uitestbasics/drawable/ic_launcher_background.xml")


        val intentResult = Intent()
        intentResult.setData(imageUri)

        return Instrumentation.ActivityResult(Activity.RESULT_OK, intentResult)

    }
}
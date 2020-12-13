package com.hani.uitestbasics.main.ui

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.hani.uitestbasics.R
import kotlinx.android.synthetic.main.activity_main.*

const val CAMERA_REQUEST_CODE = 1234
const val KEY_IMAGE_DATA = "data"

class MainActivity : AppCompatActivity() {

    private val TAG: String = "AppDebug"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_camera.setOnClickListener {
            pickFromGallery()
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            Log.d(TAG, "RESULT_OK")
            when (requestCode) {

                CAMERA_REQUEST_CODE -> {
                    Log.d(TAG, "GALLERY_REQUEST_CODE detected.")
                    data?.extras?.let { extras ->
                        if (!extras.containsKey(KEY_IMAGE_DATA)) {
                            return
                        }
                        val imageBitmap = extras[KEY_IMAGE_DATA] as Bitmap?
                        image.setImageBitmap(imageBitmap)
                    }
                }
            }
        }
    }

    private fun pickFromGallery() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, CAMERA_REQUEST_CODE)
    }

}
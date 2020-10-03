package com.homingos.sdktest

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.homingos.sdk.upload.HomingosUploader

class MainActivity : AppCompatActivity() {

    var uri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnSelectFile).setOnClickListener {
            startActivityForResult(
                Intent(
                    Intent.ACTION_PICK,
                    android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
                ), 1234
            )
        }

        findViewById<Button>(R.id.btnUpload).setOnClickListener {
            HomingosUploader.getInstance(this).upload(uri!!, "5e6eb94e-6ac6-4f61-84af-c764c4c8d27e")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == 1234) {
            uri = data?.data
        } else super.onActivityResult(requestCode, resultCode, data)
    }

}
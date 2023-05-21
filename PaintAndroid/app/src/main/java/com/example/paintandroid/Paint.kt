package com.example.paintandroid

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.paintandroid.PaintView.Companion.currentBrush
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.util.DisplayMetrics
import com.example.paintandroid.R.id.Engleski
import java.util.Locale
import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Environment
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class Paint : AppCompatActivity() {
    private lateinit var btn_save: Button
    private lateinit var PaintDio: RelativeLayout

    companion object{
        var path = Path()
        var paintBrush = Paint()
        private const val REQUEST_PERMISSION_WRITE_EXTERNAL_STORAGE = 1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paint)
        supportActionBar?.hide()

        PaintDio = findViewById(R.id.PaintDio)
        val redBtn = findViewById<ImageButton>(R.id.redColor)
        val bluBtn = findViewById<ImageButton>(R.id.blueColor)
        val grnBtn = findViewById<ImageButton>(R.id.greenColor)
        val eraser = findViewById<ImageButton>(R.id.whiteColor)
        val blkBtn = findViewById<ImageButton>(R.id.blackColor)
        val btn_save: Button = findViewById(R.id.btn_save)

        btn_save.setOnClickListener {
            captureScreenshot()
        }



        redBtn.setOnClickListener {
            paintBrush.color = Color.RED
            currentColor(paintBrush.color)

        }

        bluBtn.setOnClickListener {
            paintBrush.color = Color.BLUE
            currentColor(paintBrush.color)
        }

        grnBtn.setOnClickListener {
            paintBrush.color = Color.GREEN
            currentColor(paintBrush.color)

        }

        blkBtn.setOnClickListener {
            paintBrush.color = Color.BLACK
            currentColor(paintBrush.color)

        }

        eraser.setOnClickListener {
            paintBrush.color = Color.WHITE
            currentColor(paintBrush.color)

        }


    }

    private fun currentColor(color: Int){
        currentBrush = color
        path = Path()
    }

    private fun captureScreenshot() {
        // Check if the required permission is granted
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Request the permission if it's not granted
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                REQUEST_PERMISSION_WRITE_EXTERNAL_STORAGE
            )
        } else {
            // Permission is already granted, capture and save the screenshot
            saveScreenshot()
        }
    }

    private fun saveScreenshot() {
        val bitmap = Bitmap.createBitmap(
            PaintDio.width,
            PaintDio.height,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        PaintDio.draw(canvas)

        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val fileName = "screenshot_$timeStamp.png"
        val storageDir = Environment.getExternalStorageDirectory()
        val file = File(storageDir, fileName)

        try {
            val outputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
            outputStream.flush()
            outputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PERMISSION_WRITE_EXTERNAL_STORAGE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, capture and save the screenshot
                saveScreenshot()
            }
        }
    }

}
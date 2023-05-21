package com.example.paintandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.util.DisplayMetrics
import android.widget.Button
import com.example.paintandroid.R.id.Engleski
import java.util.Locale
import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Environment
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {



    private lateinit var switchButton: Button
    private lateinit var Hrvatski: Button
    private lateinit var Engleski: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchButton = findViewById(R.id.switchButton)

        switchButton.setOnClickListener {
            // Switch to the second activity
            val intent = Intent(this@MainActivity, Paint::class.java)
            startActivity(intent)
        }

    }

    fun changeLanguage (languageCode: String){
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val resources: Resources = resources
        val config: Configuration = resources.configuration
        val displayMetrics : DisplayMetrics = resources.displayMetrics
        config.setLocale(locale)
        resources.updateConfiguration(config, displayMetrics)
        recreate()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.language_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.Engleski -> changeLanguage("en")
            R.id.Hrvatski -> changeLanguage("hr")

        }
        return super.onOptionsItemSelected(item)
    }

}


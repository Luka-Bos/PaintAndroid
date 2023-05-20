package com.example.paintandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var switchButton: Button

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
}
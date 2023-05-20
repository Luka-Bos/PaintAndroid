package com.example.paintandroid

import android.graphics.Paint
import android.graphics.Path
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

class Paint : AppCompatActivity() {

    companion object{
        var path = Path()
        var paintBrush = Paint()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paint)

        val redBtn = findViewById<ImageButton>(R.id.redColor)
        val bluBtn = findViewById<ImageButton>(R.id.blueColor)
        val grnBtn = findViewById<ImageButton>(R.id.greenColor)
        val eraser = findViewById<ImageButton>(R.id.whiteColor)
        val blkBtn = findViewById<ImageButton>(R.id.blackColor)

        redBtn.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()

        }

        bluBtn.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
        }

        grnBtn.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()

        }

        blkBtn.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()

        }

        eraser.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()

        }
    }
}